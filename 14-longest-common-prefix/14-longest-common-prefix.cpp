class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans = strs[0];
        for (int i = 1; i < strs.size(); i++) {
            string curr = strs[i];
            int p1 = 0, p2 = 0;
            string common = "";
            while (p1 < ans.size() && p2 < curr.size()) {
                if (ans[p1] == curr[p2]) {
                    common += ans[p1];
                    p1++;
                    p2++;
                }
                else
                    break;
            }
            ans = common;
        }
        return ans;
    }
};