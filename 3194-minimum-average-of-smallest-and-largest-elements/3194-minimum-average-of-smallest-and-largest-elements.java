class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1, times = nums.length / 2;
        double ans = 52;
        while (times > 0) {
            double avg = (nums[p1] + nums[p2]) / (double) 2;
            ans = Math.min(ans, avg);
            p1++;
            p2--;
            times--;
        }
        return ans;
    }
}