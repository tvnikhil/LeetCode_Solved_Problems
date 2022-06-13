class Solution {
public:
    int dp[201][201];
    int ans(vector<vector<int>>& tr, int row, int col) {
        if (dp[row][col] != -1)
            return dp[row][col];
        if (row == tr.size())
            return 0;
        int l = tr[row][col] + ans(tr, row+1, col);
        int r = tr[row][col] + ans(tr, row+1, col+1);
        dp[row][col] = min(l,r);
        return dp[row][col];
    }
    int minimumTotal(vector<vector<int>>& triangle) {
        for (int i = 0; i < 201; i++)
            for (int j = 0; j < 201; j++)
                dp[i][j] = -1;
        return ans(triangle, 0, 0);
    }
};