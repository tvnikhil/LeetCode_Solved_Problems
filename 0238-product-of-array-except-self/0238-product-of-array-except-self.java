class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        int[] res = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        int p1 = 1, p2 = nums.length - 2;
        while (p1 < nums.length && p2 >= 0) {
            left[p1] = left[p1 - 1] * nums[p1 - 1];
            p1++;
            right[p2] = right[p2 + 1] * nums[p2 + 1];
            p2--;
        }
        for (int i = 0; i < nums.length; i++)
            res[i] = left[i] * right[i];
        return res;
    }
}