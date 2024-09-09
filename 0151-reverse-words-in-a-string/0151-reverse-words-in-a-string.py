class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        r = s.split(" ")[::-1]
        ans = ""
        
        for i in r:
            i = i.strip()
            if i == "":
                continue
            ans += i + " "
        
        return ans[0:len(ans)-1]