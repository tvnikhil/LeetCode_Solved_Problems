class Solution {
    public int majorityElement(int[] nums) {
        // Moore's voting algorithm
        int majorityElement = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement)
                count++;
            else
                count--;
            if (count == 0) {
                majorityElement = nums[i+1];
                count = 0;
            }
        }
        return majorityElement;
    }
}