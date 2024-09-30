class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = {}
        
        def dfs(idx):
            if idx >= len(arr):
                return 0
            if idx in dp:
                return dp[idx]
            
            ans = -1
            for size in range(1, k+1):
                st, end = idx, idx+size
                if end > len(arr):
                    break
                ans = max(ans, (max(arr[st:end])*size) + dfs(end))
            
            dp[idx] = ans
            return ans
            
        return dfs(0)
        