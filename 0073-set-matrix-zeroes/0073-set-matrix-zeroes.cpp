class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector <int> rows;
        vector <int> cols;
        int m = matrix.size(), n = matrix[0].size();
        // cout << m << " " << n << endl;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.push_back(i);
                    cols.push_back(j);
                }
            }
        }
        // for (int i = 0; i < rows.size(); i++)
        //     cout << rows[i] << " ";
        // cout << endl;
        // for (int i = 0; i < cols.size(); i++)
        //     cout << cols[i] << " ";
        // cout << endl;
        int rowLen = rows.size(), colsLen = cols.size();
        for (int row = 0; row < rowLen; row++) {
            int r = rows[row];
            for (int i = 0; i < n; i++) {
                matrix[r][i] = 0;
            }
        }
        for (int col = 0; col < colsLen; col++) {
            int c = cols[col];
            for (int i = 0; i < m; i++) {
                matrix[i][c] = 0;
            }
        }
    }
};