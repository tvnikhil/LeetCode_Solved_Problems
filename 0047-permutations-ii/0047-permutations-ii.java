class Solution {
    public void helper(int[] nums, Map<Integer, Integer> hm, 
                       List<Integer> currList,
                       List<List<Integer>> ans) {
        if (currList.size() == nums.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > 0) {
                currList.add(key);
                hm.put(key, hm.get(key)-1);
                helper(nums, hm, currList, ans);
                hm.put(key, hm.get(key)+1);
                currList.remove(currList.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i]) + 1);
            else
                hm.put(nums[i], 1);
        }
        helper(nums, hm, currList, ans);
        return ans;
    }
}