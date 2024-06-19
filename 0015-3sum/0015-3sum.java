class Solution {
    public Set<List<Integer>> twoSum(int[] nums, int fromIdx, int sum, Set<List<Integer>> st) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = fromIdx; i < nums.length; i++) {
            if (hm.get(sum - nums[i]) != null) {
                List<Integer> temp = Arrays.asList(nums[fromIdx - 1], nums[i], nums[hm.get(sum - nums[i])]);
                hm.put(nums[i], i);
                temp.sort(null);
                st.add(temp);
            }
            else
                hm.put(nums[i], i);
        }
        return st;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++)
            st = twoSum(nums, i+1, 0-nums[i], st);
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}