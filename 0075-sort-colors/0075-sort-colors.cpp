class Solution {
public:
    void sortColors(vector<int>& nums) {
        int z, o, t;
        z = o = t = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) z++;
            if (nums[i] == 1) o++;
            if (nums[i] == 2) t++;
        }
        int i = 0, c = 0;
        for (; i < z; i++)
            nums[c++] = 0;
        i = 0;
        for (; i < o; i++)
            nums[c++] = 1;
        i = 0;
        for (; i < t; i++)
            nums[c++] = 2;
    }
};