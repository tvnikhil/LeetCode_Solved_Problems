class Solution:
    def lcs(self, word1, word2, ptr1, ptr2, mem):
        if ptr1 == len(word1) or ptr2 == len(word2):
            return 0
        if mem[ptr1][ptr2] != -1:
            return mem[ptr1][ptr2]
        if word1[ptr1] == word2[ptr2]:
            a = self.lcs(word1, word2, ptr1+1, ptr2+1, mem)
            mem[ptr1][ptr2]= 1 + a
            return mem[ptr1][ptr2]
        a = self.lcs(word1, word2, ptr1+1, ptr2, mem)
        b = self.lcs(word1, word2, ptr1, ptr2+1, mem)
        mem[ptr1][ptr2] = max(a, b)
        return mem[ptr1][ptr2]

    def minDistance(self, word1: str, word2: str) -> int:
        mem = [[-1] * (len(word2) + 1) for _ in range(len(word1) + 1)]
        maxLcs = self.lcs(word1, word2, 0, 0, mem)
        return (len(word1) - maxLcs) + (len(word2) - maxLcs)
        