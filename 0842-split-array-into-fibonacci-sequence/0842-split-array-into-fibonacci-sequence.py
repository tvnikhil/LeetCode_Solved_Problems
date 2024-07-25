class Solution:
    def dfs(self, num, seq):
        if len(seq) > 2:
            if (seq[-1]) != (seq[-2]) + (seq[-3]): return []
        if len(num) == 0 and len(seq) >= 3:
            return seq
        for i in range(0, len(num)):
            left = num[0:i+1]
            if len(left) > 1 and left[0] == "0":
                continue
            if int(left) >= 2**31:
                break
            seq.append(int(left))
            if self.dfs(num[i+1:], seq) != []: return seq
            seq.pop()
        return []
    
    def splitIntoFibonacci(self, num: str) -> List[int]:
        seq = []
        seq = self.dfs(num, seq)
        return seq
        