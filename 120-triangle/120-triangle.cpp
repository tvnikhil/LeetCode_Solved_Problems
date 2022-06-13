class Solution {
public:
    int ans(vector<vector<int>>& tr, int row, int col, vector<vector<int>> &dp) {
        if (dp[row][col] != -1)
            return dp[row][col];
        if (row == tr.size()-1)
            return tr[row][col];
        if (col >= tr[row].size())
            return INT_MAX;
        int l = ans(tr, row+1, col, dp);
        int r = ans(tr, row+1, col+1, dp);
        dp[row][col] = min(l,r) + tr[row][col];
        return dp[row][col];
    }
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        int m = triangle[n-1].size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        return ans(triangle, 0, 0, dp);
    }
};