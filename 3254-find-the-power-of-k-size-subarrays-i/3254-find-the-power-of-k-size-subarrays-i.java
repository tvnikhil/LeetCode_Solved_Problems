class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] idx = new int[nums.length];
        idx[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1)
                idx[i] = idx[i-1];
            else
                idx[i] = i;
        }
        int st = 0;
        int x = 0;
        int[] res = new int[nums.length-k+1];
        for (int i = k-1; i < nums.length; i++) {
            if (idx[i] <= st)
                res[x++] = nums[i];
            else
                res[x++] = -1; 
            st++;
        }
        return res;
    }
}