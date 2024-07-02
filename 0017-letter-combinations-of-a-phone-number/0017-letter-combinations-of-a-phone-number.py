class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        d2l = {}
        d2l["2"] = ["a", "b", "c"]
        d2l["3"] = ["d", "e", "f"]
        d2l["4"] = ["g", "h", "i"]
        d2l["5"] = ["j", "k", "l"]
        d2l["6"] = ["m", "n", "o"]
        d2l["7"] = ["p", "q", "r", "s"]
        d2l["8"] = ["t", "u", "v"]
        d2l["9"] = ["w", "x", "y", "z"]
        
        tAns = [""]
        res = []
        for i in digits:
            combo = []
            letters = d2l[i]
            for x in tAns:
                for y in letters:
                    xy = x + y
                    combo.append(str(xy))
                    if len(xy) == len(digits):
                        res.append(str(xy))
            tAns += combo
        return res
        