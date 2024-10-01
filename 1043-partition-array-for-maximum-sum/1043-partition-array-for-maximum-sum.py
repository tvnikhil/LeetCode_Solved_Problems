class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [-1 for _ in range(n)]
        dp[n-1] = arr[n-1]
        
        for i in range(n-2, -1, -1):
            maxi = -1
            for size in range(1, k+1):
                st, end = i, i+size
                if end > n:
                    break
                maxi = max(maxi, arr[end-1])
                res = maxi*size
                if end != n:
                    res += dp[end]
                dp[i] = max(dp[i], res)
        
        return dp[0]

# class Solution:
#     def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
#         dp = {}
        
#         def dfs(idx):
#             if idx >= len(arr):
#                 return 0
#             if idx in dp:
#                 return dp[idx]
            
#             ans = -1
#             for size in range(1, k+1):
#                 st, end = idx, idx+size
#                 if end > len(arr):
#                     break
#                 ans = max(ans, (max(arr[st:end])*size) + dfs(end))
            
#             dp[idx] = ans
#             return ans
        
#         return dfs(0)
        