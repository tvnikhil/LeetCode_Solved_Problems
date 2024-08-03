class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        d = {}
        cnt = {}
        for i in range(0,11):
            cnt[i] = 0
        for i in range(0,len(pick)):
            if pick[i][0] in d:
                temp = d[pick[i][0]]
                temp[pick[i][1]] += 1
            else:
                d[pick[i][0]] = dict(cnt)
                temp = d[pick[i][0]]
                temp[pick[i][1]] += 1
        wins = 0
        for i in d:
            if i == 0:
                wins += 1
            else:
                temp = d[i]
                for j in temp:
                    if temp[j] >= i+1:
                        wins += 1
                        break
        return wins
        