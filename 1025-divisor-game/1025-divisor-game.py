class Solution:
    def divisorGame(self, n: int) -> bool:
        r, c = n+1, 2
        dp = [[0 for _ in range(c)] for _ in range(r)]
        dp[1][0] = 1
        dp[1][1] = 0
        
        for i in range(2, r):
            for j in range(c):
                
                flag = False
                for x in range(1, (i//2)+1):
                    if i % x == 0:
                        if dp[i-x][1-j] == j:
                            dp[i][j] = j
                            flag = True
                            break
                
                if flag == False:
                    dp[i][j] = 1-j
        
        print(dp)
        
        return True if dp[n][0] == 0 else False

# class Solution:
#     def divisorGame(self, n: int) -> bool:
#         # return True if n % 2 == 0 else False
#         dp = {}
#         #Alice = 0, Bob = 1
        
#         def dfs(n, move):
#             if n == 1:
#                 return 1-move
#             if (n, move) in dp:
#                 return dp[(n, move)]
            
#             for x in range(1, n):
#                 if n % x == 0:
#                     dp[(n-x, 1-move)] = dfs(n-x, 1-move)
#                     if dp[(n-x, 1-move)] == move:
#                         return move
            
#             return 1-move
        
#         ans = dfs(n, 0)
#         # print(dp)
#         return True if ans == 0 else False
        