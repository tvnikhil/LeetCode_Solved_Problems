class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count_0 = 0, count_1 = 0, count_2 = 0;
        for (int i: nums) {
            if (i == 0)
                count_0++;
            else if (i == 1)
                count_1++;
            else
                count_2++;
        }
        // cout << count_0 << " " << count_1 << " " << count_2 << endl;
        for (int i = 0; i < nums.size(); i++) {
            if (count_0 > 0) {
                nums[i] = 0;
                count_0--;
            }
            else if (count_1 > 0) {
                nums[i] = 1;
                count_1--;
            }
            else {
                nums[i] = 2;
                count_2--;
            }
        }
    }
};