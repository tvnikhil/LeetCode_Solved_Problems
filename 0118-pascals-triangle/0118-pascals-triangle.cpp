class Solution {
public:
    vector<int> returnPrevRowAdjSum(vector<vector<int>> pascal_traingle, int r) {
        vector <int> temp;
        vector <int> toSum = pascal_traingle[r];
        // for (int i = 0; i < toSum.size(); i++)
        //     cout << toSum[i] << " ";
        // cout << endl;
        for (int i = 1; i < toSum.size(); i++) {
            temp.push_back(toSum[i-1] + toSum[i]);
        }
        // for (int i = 0; i < temp.size(); i++)
        //     cout << temp[i] << " ";
        // cout << endl;
        return temp;
    }
    
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> pascal_triangle;
        vector<int> v1 {1};
        vector<int> v2{1, 1};
        pascal_triangle.push_back(v1);
        if (numRows == 1)
            return pascal_triangle;
        pascal_triangle.push_back(v2); 
        if (numRows == 2)
            return pascal_triangle;
        for (int i = 2; i < numRows; i++) {
            // to return -- previous row adj sum vector
            vector<int> temp = returnPrevRowAdjSum(pascal_triangle, i-1);
            temp.push_back(1);
            temp.insert(temp.begin(), 1);
            pascal_triangle.push_back(temp);
        }
        return pascal_triangle;
    }
};