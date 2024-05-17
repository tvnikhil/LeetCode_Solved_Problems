class Solution {
    public int maxSubArray(int[] nums) {
        int[] cSum = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                cSum[i] = nums[i];
            else if (cSum[i - 1] < 0)
                cSum[i] = nums[i];
            else if (cSum[i-1] >= 0)
                cSum[i] = cSum[i-1] + nums[i];
            maxSum = (cSum[i] > maxSum) ? cSum[i] : maxSum;
        }
        return maxSum;
    }
}