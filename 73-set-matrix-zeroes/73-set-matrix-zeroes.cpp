class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        vector<int> rows(matrix.size());
        vector<int> cols(matrix[0].size());
        fill(rows.begin(), rows.end(), 0);
        fill(cols.begin(), cols.end(), 0);
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.size(); i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < cols.size(); j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < cols.size(); i++) {
            if (cols[i] == 1) {
                for (int j = 0; j < rows.size(); j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
};