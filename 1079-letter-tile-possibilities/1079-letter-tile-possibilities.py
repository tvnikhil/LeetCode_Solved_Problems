class Solution:
    def generate(self, hm, currString, currLen, limitLen, ans):
        if currLen == limitLen:
            return ans+1
        for letter in hm:
            if hm[letter] > 0:
                hm[letter] -= 1
                ans = self.generate(hm, currString+letter, currLen+1, limitLen, ans)
                hm[letter] += 1
        return ans
    
    def numTilePossibilities(self, tiles: str) -> int:
        hm = {}
        for i in tiles:
            if i in hm:
                hm[i] += 1
            else:
                hm[i] = 1
        n = len(tiles)
        ans = 0
        for limitLen in range(1, n+1):
            ans = self.generate(hm, "", 0, limitLen, ans)
        return ans
        