class Solution {
    public void generateSubsets(int[] nums, int idx, List<Integer> subset, Set<ArrayList<Integer>> st) {
        if (idx >= nums.length) {
            st.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[idx]);
        generateSubsets(nums, idx + 1, subset, st);
        subset.remove(subset.size() - 1);
        generateSubsets(nums, idx + 1, subset, st);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> st = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        generateSubsets(nums, 0, subset, st);
        return new ArrayList<>(st);
    }
}