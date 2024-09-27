class Solution:
    def divisorGame(self, n: int) -> bool:
        # return True if n % 2 == 0 else False
        dp = {}
        #Alice = 0, Bob = 1
        
        def dfs(n, move):
            if n == 1:
                return 1-move
            if (n, move) in dp:
                return dp[(n, move)]
            
            for x in range(1, n):
                if n % x == 0:
                    dp[(n-x, 1-move)] = dfs(n-x, 1-move)
                    if dp[(n-x, 1-move)] == move:
                        return move
            
            return 1-move
        
        ans = dfs(n, 0)
        # print(dp)
        return True if ans == 0 else False
        