class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // int[] prefixSum = new int[nums.length];
        // prefixSum[0] = nums[0];
        // for (int i = 1; i < nums.length; i++)
        //     prefixSum[i] = prefixSum[i - 1] + nums[i];
        // int subArrSum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (i == 0)
        //             subArrSum = prefixSum[j];
        //         else
        //             subArrSum = prefixSum[j] - prefixSum[i - 1];
        //         if (subArrSum % k == 0)
        //                 return true;
        //     }
        // }
        // return false;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem == 0 && i >= 1)
                return true;
            else if (rem == 0 && i == 0)
                hm.put(0, i);
            else {
                if (hm.containsKey(rem)) {
                    if (i - hm.get(rem) >= 2)
                        return true;
                }
                else
                    hm.put(rem, i);
            }
            sum = rem;
        }
        return false;
    }
}