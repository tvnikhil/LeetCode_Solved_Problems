class Solution:
    # def dfs(self, curr, idx, n, even, prime, cnt):
    #     if idx >= n:
    #         return cnt+1
    #     if idx % 2 == 0:
    #         for i in even:
    #             cnt = self.dfs(curr+str(i), idx+1, n, even, prime, cnt)
    #     else:
    #         for i in prime:
    #             cnt = self.dfs(curr+str(i), idx+1, n, even, prime, cnt)
    #     return cnt
    
    def countGoodNumbers(self, n: int) -> int:
        # even = [0,2,4,6,8]
        # prime = [2,3,5,7]
        # currString = ""
        # idx = 0
        # cnt = self.dfs(currString, idx, n, even, prime, 0)
        # return cnt
        # cnt = 1
        MOD_VAL = pow(10,9) + 7
        # for i in range(0, n):
        #     if i % 2 == 0:
        #         cnt = (cnt * 5) % MOD_VAL
        #     else:
        #         cnt = (cnt * 4) % MOD_VAL
        # return cnt
        if n == 1:
            return 5
        if n % 2 == 0:
            return (pow(5, n//2, MOD_VAL) * pow(4, n//2, MOD_VAL)) % MOD_VAL
            # return (5**(n//2) * 4**(n//2)) % MOD_VAL
        else:
            return (pow(5, (n//2)+1, MOD_VAL) * pow(4, n//2, MOD_VAL)) % MOD_VAL
            # return (5**((n//2)+1) * 4**((n//2))) % MOD_VAL
        