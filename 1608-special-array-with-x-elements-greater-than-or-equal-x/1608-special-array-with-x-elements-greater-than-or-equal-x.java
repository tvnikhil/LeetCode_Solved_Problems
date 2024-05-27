class Solution {
    public int specialArray(int[] nums) {
        int max = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i <= 1000; i++)
            hm.put(i, 0);
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int temp = hm.get(nums[i]);
            hm.put(nums[i], ++temp);
        }
        int[] cFreq = new int[max + 1];
        cFreq[max] = hm.get(max);
        for (int i = max-1; i >= 0; i--) {
            cFreq[i] = hm.get(i) + cFreq[i + 1];
        }
        for (int i = 0; i <= max; i++) {
            if (i == cFreq[i])
                return cFreq[i];
        }
        return -1;
    }
}