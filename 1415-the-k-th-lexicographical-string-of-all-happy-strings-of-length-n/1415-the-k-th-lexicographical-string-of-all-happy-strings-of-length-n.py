class Solution:
    def dfs(self, n, k, currString, rank, kStr):
        if len(currString) == n:
            rank[0] += 1
            if rank[0] == k:
                kStr[0] = currString
            return
        if len(currString) == 0 or currString[-1] == 'b' or currString[-1] == 'c':
            self.dfs(n, k, currString+"a", rank, kStr)
            if kStr[0] != "":
                return
        if len(currString) == 0 or currString[-1] == 'c' or currString[-1] == 'a':
            self.dfs(n, k, currString+"b", rank, kStr)
            if kStr[0] != "":
                return
        if len(currString) == 0 or currString[-1] == 'a' or currString[-1] == 'b':
            self.dfs(n, k, currString+"c", rank, kStr)
            if kStr[0] != "":
                return
    
    def getHappyString(self, n: int, k: int) -> str:
        kStr = [""]
        rank = [0]
        currString = ""
        self.dfs(n, k, currString, rank, kStr)
        return kStr[0]
        