class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0, xor2 = 0, high = nums.length;
        for (int i = 0; i < high; i++) {
            xor1 ^= nums[i];
            xor2 ^= i;
        }
        xor2 ^= high;
        return xor1 ^ xor2;
    }
}