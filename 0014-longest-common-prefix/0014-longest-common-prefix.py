class Solution:
    def longestCommonPrefix(self, st: List[str]) -> str:
        #your code goes here
        st = sorted(st)
        ans = ""
        for i in range(0, len(st[0])):
            for j in range(1, len(st)):
                if len(st[j]) < i+1 or st[0][i] != st[j][i]:
                    return ans
            ans += st[0][i]
        return ans
        