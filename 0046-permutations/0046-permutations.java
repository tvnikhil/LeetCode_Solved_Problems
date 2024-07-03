class Solution {
    public void generateAllPermutations(int[] nums, List<Integer> seen, 
                                        List<Integer> currList, List<List<Integer>> ans) {
        if (currList.size() == nums.length) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < seen.size(); i++) {
            if (seen.get(i) != 1) {
                currList.add(nums[i]);
                seen.set(i, 1);
                generateAllPermutations(nums, seen, currList, ans);
                currList.remove(currList.size() - 1);
                seen.set(i, 0);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> seen = new ArrayList<>(Collections.nCopies(nums.length, 0));
        List<Integer> currList = new ArrayList<>();
        generateAllPermutations(nums, seen, currList, ans);
        return ans;
    }
}