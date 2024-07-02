class Solution {
    public void generateSubsets(int[] nums, int idx, List<Integer> subset, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subset));
        int prev = -11;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] == prev)
                continue;
            subset.add(nums[i]);
            generateSubsets(nums, i + 1, subset, ans);
            subset.remove(subset.size() - 1);
            prev = nums[i];
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, 0, subset, ans);
        return ans;
    }
}