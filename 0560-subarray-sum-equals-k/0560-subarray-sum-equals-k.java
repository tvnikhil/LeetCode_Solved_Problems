class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currSum = 0, subArrCount = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum == k) {
                subArrCount++;
            }
            if (hm.containsKey(currSum - k))
                subArrCount += hm.get(currSum - k);
            if (hm.containsKey(currSum)) {
                int val = hm.get(currSum);
                hm.put(currSum, val + 1);
            }
            if (!hm.containsKey(currSum))
                hm.put(currSum, 1);
            //System.out.println(currSum + " " + subArrCount);
        }
        return subArrCount;
    }
}