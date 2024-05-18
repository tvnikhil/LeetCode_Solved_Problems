class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1, currMax = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] == 1)
                currMax++;
            else
                currMax = 0;
            max = (currMax > max) ? currMax: max;
            i++;
        }
        return max;
    }
}