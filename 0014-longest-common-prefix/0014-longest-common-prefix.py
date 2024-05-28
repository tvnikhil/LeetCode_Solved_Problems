class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1:
            return strs[0]
        ans, idx, first = "", 0, strs[0]
        if len(first) == 0: return ""
        flag = 0
        for idx in range(0, len(first)):
            for i in range(1, len(strs)):
                if len(strs[i]) == 0: return ""
                if idx >= len(strs[i]) or first[idx] != strs[i][idx]:
                    flag = 1
                    break
            if flag == 1: break
            ans += first[idx]
            idx += 1
        return ans