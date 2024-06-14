class Solution {
    public int minIncrementForUnique(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                num++;
                continue;
            }
            else if (nums[i] > num) {
                num = nums[i] + 1;
                continue;
            }
            else {
                ans += num - nums[i];
                num += 1;
            }
        }
        return ans;
    }
}