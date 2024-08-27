from collections import deque

class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        adj = defaultdict(list)
        for st, end in edges:
            adj[st].append(end)
            adj[end].append(st)
        que = deque()
        visTimes = defaultdict(list)
        que.append(1)
        currTime = 0
        res = -1
        
        while que:
            for i in range(len(que)):
                node = que.popleft()
                if node == n:
                    if res != -1:
                        return currTime
                    res = currTime    
                for neigh in adj[node]:
                    neighVisTimes = visTimes[neigh]
                    size = len(neighVisTimes)
                    if size == 0 or (size == 1 and neighVisTimes[-1] != currTime):
                        que.append(neigh)
                        neighVisTimes.append(currTime)
                        
            if (currTime // change) % 2 != 0:
                currTime += (change - currTime % change)
            currTime += time
        return 0
        
        