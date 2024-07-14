class Solution:
    def prec(self, op):
        if op == "*":
            return 2
        else:
            return 1
        return 0
    
    def convertExp(self, exp):
        res = []
        c = ""
        for i in range(len(exp)):
            if exp[i] in ["+", "-", "*"]:
                if len(c) > 1 and c[0] == "0":
                    return []
                res.append(c)
                res.append(exp[i])
                c = ""
            else:
                c += exp[i]
        if len(c) > 1 and c[0] == "0":
            return []
        res.append(c)
        return res
    
    def evaluate(self, exp, target):
        exp = self.convertExp(exp)
        if len(exp) == 0:
            return False
        postFix = []
        stk = []
        operators = ["+", "-", "*"]
        for i in range(0, len(exp)):
            if exp[i] not in operators:
                postFix.append(exp[i])
            else:
                while len(stk) > 0 and self.prec(stk[-1]) >= self.prec(exp[i]):
                    temp = stk.pop()
                    postFix += temp
                stk.append(exp[i])
        while len(stk) > 0:
            postFix += stk.pop()
        ans,stk = 0,[]
        for i in range(len(postFix)):
            if postFix[i] in operators:
                a = int(stk.pop())
                b = int(stk.pop())
                if postFix[i] == "+":
                    c = a + b
                elif postFix[i] == "-":
                    c = b-a
                else:
                    c = a * b
                stk.append(c)
            else:
                stk.append(postFix[i])
        #print(postFix, stk[0], target)
        if int(stk[0]) == target:
            return 1
        return 0
    
    def generate(self, num, target, currString, idx, ans):
        if idx >= len(num):
            # if currString == num:
            #     print(currString)
            if self.evaluate(currString, target):
                ans.append(str(currString))
            return
        operators = ["+", "-", "*"]
        if idx == 0 or currString[-1] in operators:
            self.generate(num, target, currString+num[idx], idx+1, ans)
        else:
            for i in operators:
                self.generate(num, target, currString+i, idx, ans)
            self.generate(num, target, currString+num[idx], idx+1, ans)
    
    def addOperators(self, num: str, target: int) -> List[str]:
        currString, idx = "", 0
        ans = []
        self.generate(num, target, currString, idx, ans)
        return ans
        