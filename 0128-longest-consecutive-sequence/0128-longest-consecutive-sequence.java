class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int maxLen = 1;
        Iterator<Integer> i = hs.iterator();
        while (i.hasNext()) {
            int val = i.next();
            if (hs.contains(val-1))
                continue;
            int currLen = 1;
            while (hs.contains(val+1)) {
                currLen++;
                val++;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}