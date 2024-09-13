import heapq as pq

class SmallestInfiniteSet:

    def __init__(self):
        self.heap = []
        self.vis = {}
        
        for i in range(1, 1001):
            pq.heappush(self.heap, i)
            self.vis[i] = True
        

    def popSmallest(self) -> int:
        if len(self.heap) > 0:
            smallest = pq.heappop(self.heap)
            self.vis[smallest] = False
            return smallest
        return None
        

    def addBack(self, num: int) -> None:
        if self.vis[num] == False:
            pq.heappush(self.heap, num)
            self.vis[num] = True
        


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)