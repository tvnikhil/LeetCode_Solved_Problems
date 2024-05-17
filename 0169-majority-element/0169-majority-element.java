import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                int val = hm.get(nums[i]);
                hm.put(nums[i], val+1);
            }
            else
                hm.put(nums[i], 1);
        }
        for (int key: hm.keySet()) {
            if (hm.get(key) > Math.floor(nums.length / 2))
                return key;
        }
        return 0;
    }
}