class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> negs;
        vector<int> pos;
        for (int i: nums) {
            if (i < 0)
                negs.push_back(i);
            else
                pos.push_back(i);
        }
        if (pos.size()==0) {
            reverse(negs.begin(), negs.end());
            return negs[0]*negs[1]*negs[2];
        }
        int ans = 1;
        if (negs.size() >= 2) {
            ans *= negs[0] * negs[1];
            cout << ans << endl;
            if (pos.size() >= 1) {
                ans *= pos[pos.size()-1];
                if (pos.size() >= 3)
                    return max(ans, pos[pos.size()-1]*pos[pos.size()-2]*pos[pos.size()-3]);
            }
            else
                ans *= negs[2];
            return ans;
        }
        return pos[pos.size()-1]*pos[pos.size()-2]*pos[pos.size()-3];
    }
};