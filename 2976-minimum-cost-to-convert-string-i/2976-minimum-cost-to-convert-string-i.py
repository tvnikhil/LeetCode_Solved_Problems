import heapq

class Solution:
    def dij(self, adj, src, dest, letters):
        if (src == dest):
            return 0
        travelCost = {}
        for i in letters:
            travelCost[i] = float("inf")
        travelCost[src] = 0
        que = [(0, src)]
        heapq.heapify(que)
        while que:
            curr = heapq.heappop(que)
            currCost, currNode = curr[0], curr[1]
            # if currCost > travelCost[currNode]: continue
            if currNode == dest:
                break
            edges = adj[currNode]
            for edge in edges:
                nextNode, nextCost = edge[0], edge[1]
                prCost = nextCost + currCost
                if prCost < travelCost[nextNode]:
                    travelCost[nextNode] = prCost
                    heapq.heappush(que, (prCost, nextNode))
        if travelCost[dest] == float("inf"): return -1
        return travelCost[dest]
    
    def minimumCost(self, source: str, target: str, org: List[str], ch: List[str], cost: List[int]) -> int:
        adj = {}
        letters = set()
        for i in source: letters.add(i)
        for i in target: letters.add(i)
        for i in org: letters.add(i)
        for i in ch: letters.add(i)
        for i in letters: adj[i] = []
        for i in range(len(org)):
            if org[i] in adj:
                adj[org[i]].append((ch[i], cost[i]))
        #print(adj)
        hm = {}
        letters = list(letters)
        for i in range(len(letters)):
            for j in range(len(letters)):
                if (letters[i], letters[j]) in hm: continue
                hm[(letters[i], letters[j])] = self.dij(adj, letters[i], letters[j], letters)
        ans = 0
        for i in range(len(source)):
            res = hm[(source[i], target[i])]
            if res == -1:
                return -1
            ans += res
        # for i in range(len(source)):
        #     if source[i] != target[i]:
        #         res = self.dij(adj, source[i], target[i], letters)
        #         if res == -1:
        #             return -1
        #         ans += res
        return ans