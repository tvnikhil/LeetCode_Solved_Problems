class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        map<int, bool> presence;
        for (int i = 0; i < nums.size(); i++) {
            presence[nums[i]] = true; 
        }
        if (presence.count(0) == 1) 
            return presence.size()-1;
        return presence.size();
    }
};