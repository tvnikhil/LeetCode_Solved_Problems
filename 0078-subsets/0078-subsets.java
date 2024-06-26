class Solution {
    public ArrayList<ArrayList<Integer>> returnAllSubSets(int[] nums, int idx, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(subSet));
            return ans;
        }
        subSet.add(nums[idx]);
        ans = returnAllSubSets(nums, idx + 1, subSet, ans);
        subSet.remove(subSet.size() - 1);
        ans = returnAllSubSets(nums, idx + 1, subSet, ans);
        return ans;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subSet = new ArrayList<>();
        ans = returnAllSubSets(nums, 0, subSet, ans);
        return new ArrayList<>(ans);
    }
}