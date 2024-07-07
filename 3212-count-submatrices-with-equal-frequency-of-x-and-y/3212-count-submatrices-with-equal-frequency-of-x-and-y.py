class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        cnts = []
        r = len(grid)
        c = len(grid[0])
        for i in range(0, r):
            x, y = 0, 0
            rowList = []
            for j in range(0, c):
                if grid[i][j] == "X":
                    x += 1
                elif grid[i][j] == "Y":
                    y += 1
                rowList.append([x, y])
            cnts.append(list(rowList))
        dp = []
        for i in range(r):
            row = []
            for j in range(c):
                row.append([0,0])
            dp.append(row)
        dp[0] = list(cnts[0])
        for j in range(1, r):
            t, p, d = dp[j][0], dp[j-1][0], cnts[j][0]
            t[0] = p[0] + d[0]
            t[1] = p[1] + d[1]
        for i in range(1, r):
            for j in range(1, c):
                t = dp[i][j]
                p = dp[i-1][j]
                d = cnts[i][j]
                t[0] = p[0] + d[0]
                t[1] = p[1] + d[1]
        ans = 0
        for i in range(0, r):
            for j in range(0, c):
                t = dp[i][j]
                if t[0] >= 1 and t[0] == t[1]:
                    ans += 1
        return ans



        