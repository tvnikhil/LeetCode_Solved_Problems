class Solution:
    def minChanges(self, n: int, k: int) -> int:
        if n == k:
            return 0
        nBin, kBin = bin(n)[2:], bin(k)[2:]
        l = max(len(nBin), len(kBin))
        if l - len(nBin):
            nBin = "0"*(l-len(nBin)) + nBin
        elif l - len(kBin):
            kBin = "0"*(l-len(kBin)) + kBin
        print(nBin, kBin)
        ans = 0
        for i in range(0, l):
            if nBin[i] == "1" and kBin[i] == "0":
                ans += 1
            elif nBin[i] == "0" and kBin[i] == "1":
                return -1
        return ans

        