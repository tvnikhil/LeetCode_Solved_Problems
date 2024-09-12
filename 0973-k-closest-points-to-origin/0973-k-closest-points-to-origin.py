import heapq as pq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        ans = []
        
        for x, y in points:
            dist = math.sqrt(x*x + y*y)
            pq.heappush(heap, (dist, x, y))
        
        while k > 0:
            dt, x, y = pq.heappop(heap)
            ans.append([x,y])
            k -= 1
        
        return ans