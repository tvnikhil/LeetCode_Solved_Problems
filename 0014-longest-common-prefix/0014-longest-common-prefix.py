class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1:
            return strs[0]
        
        first = strs[0]
        ans = ""
        
        for idx in range(0, len(first)):
            flag = True
            for s in range(1, len(strs)):
                if idx >= len(strs[s]) or first[idx] != strs[s][idx]:
                    flag = False
                    break
            if flag == False:
                break
            ans += first[idx]
        
        return ans
        