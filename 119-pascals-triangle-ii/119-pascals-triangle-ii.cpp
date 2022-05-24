class Solution {
public:
    vector<int> getRow(int rows) {
        vector<vector<int>> res{{1}, {1, 1}};
        if(rows==0){
            vector<vector<int>> g{{1}};
            return g[0];
        }
        if (rows == 1)
            return res[1];
        for (int i = 2; i <=rows; i++) {
            vector<int> v(i+1, 1);
            int l = 0, r = 1, a = 1;
            while (r < res[i-1].size()) {
                v[a] = res[i-1][l] + res[i-1][r];
                a++;
                l++;
                r++;
            }
            res.push_back(v);
        }
        return res[rows];
    }
};