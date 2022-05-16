class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        // int last = 1;
        // for (int i = 1; i < nums.size(); i++) {
        //     if (nums[i-1] == nums[i]) {
        //         // cout << "Yes " << nums[i] << " " << nums[i-1] << " " << i << endl;
        //         int pos = nums.size()-last;
        //         for (int j = i; j < pos; j++)
        //             swap(nums[j], nums[j+1]);
        //         last++;
        //         i--;
        //     }
        //     // for (int k: nums)
        //     //     cout << k << " ";
        //     // cout << endl;
        //     if (i == nums.size()-last)
        //         break;
        // }
        // // for (int i: nums)
        // //     cout << i << " ";
        // // cout << endl;
        // // cout << last << endl;
        // return nums.size()-last+1;
        int left = 1, right = 1;
        while (right < nums.size()) {
            if (nums[right-1] == nums[right])
                right++;
            else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }
};