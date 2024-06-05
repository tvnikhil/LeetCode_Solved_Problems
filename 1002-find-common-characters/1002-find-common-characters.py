class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        ans = []
        dictList = list()
        for i in words:
            d = {}
            for j in i:
                if j in d:
                    d[j] += 1
                else:
                    d[j] = 1
            dictList.append(d)
        for i in words[0]:
            flag = 1
            for j in range(1, len(words)):
                d = dictList[j]
                if i not in d or d[i] == 0:
                    flag = 0
                    break
                d[i] -= 1
            if (flag == 1):
                ans.append(i)
        return ans
        