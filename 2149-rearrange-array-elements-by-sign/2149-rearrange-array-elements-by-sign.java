class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                pos[p1++] = nums[i];
            else
                neg[p2++] = nums[i];
        }
        int choice = 0;
        p1 = 0; p2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (choice == 0) {
                nums[i] = pos[p1++];
                choice = 1;
            }
            else {
                nums[i] = neg[p2++];
                choice = 0;
            }
        }
        return nums;
    }
}