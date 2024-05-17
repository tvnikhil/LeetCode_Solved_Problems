class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ansArr = new int[nums.length];
        int last = nums.length-1;
        int p = 0, q = nums.length - 1;
        while (p <= q) {
            if (Math.abs(nums[p]) < Math.abs(nums[q])) {
                ansArr[last--] = (nums[q] * nums[q]);
                q--;
            }
            else if (Math.abs(nums[p]) > Math.abs(nums[q])) {
                ansArr[last--] = (nums[p] * nums[p]);
                p++;
            }
            else if (p == q) {
                ansArr[last--] = nums[p] * nums[p];
                p++;
                q--;
            }
            else {
                ansArr[last--] = (nums[p] * nums[p]);
                ansArr[last--] = (nums[q] * nums[q]);
                p++;
                q--;
            }
        }
        return ansArr;
    }
}