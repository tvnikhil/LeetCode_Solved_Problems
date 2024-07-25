class Solution:
    def dfs(self, num, seq):
        if len(seq) > 2:
            if int(seq[-1]) != int(seq[-2]) + int(seq[-3]):
                return False
            if len(num) == 0:
                # print(seq)
                return True
        for i in range(0, len(num)):
            left = num[0:i+1]
            if len(left) > 1 and left[0] == "0": continue
            seq.append(left)
            ans = self.dfs(num[i+1:], seq)
            seq.pop()
            if ans: return True
        return False
    
    def isAdditiveNumber(self, num: str) -> bool:
        seq = []
        ans = self.dfs(num, seq)
        return ans