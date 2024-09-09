class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        decomps = []
        stk = []
        temp = ""
        ans = ""
        
        for i in range(len(s)):
            if len(stk) == 0:
                decomps.append(temp)
                temp = temp[1:len(temp)-1]
                ans += temp
                temp = ""
            temp += s[i]
            if s[i] == "(":
                stk.append(s[i])
            else:
                stk.pop(len(stk)-1)
        decomps.append(temp)
        temp = temp[1:len(temp)-1]
        ans += temp
        
        return ans
            
        