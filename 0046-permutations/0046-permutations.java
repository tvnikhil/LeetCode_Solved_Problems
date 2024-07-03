class Solution {
    public void swap(int a, int b, int[] nums) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
    
    public void helper(int idx, int[] nums, List<List<Integer>> ans) {
        if (idx >= nums.length) {
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                currList.add(nums[i]);
            ans.add(currList);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            helper(idx+1, nums, ans);
            swap(i, idx, nums);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans);
        return ans;
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> seen = new ArrayList<>(Collections.nCopies(nums.length, 0));
        // List<Integer> currList = new ArrayList<>();
        // generateAllPermutations(nums, seen, currList, ans);
        // return ans;
    }
    
    // public void generateAllPermutations(int[] nums, List<Integer> seen, 
    //                                     List<Integer> currList, List<List<Integer>> ans) {
    //     if (currList.size() == nums.length) {
    //         ans.add(new ArrayList<>(currList));
    //         return;
    //     }
    //     for (int i = 0; i < seen.size(); i++) {
    //         if (seen.get(i) != 1) {
    //             currList.add(nums[i]);
    //             seen.set(i, 1);
    //             generateAllPermutations(nums, seen, currList, ans);
    //             currList.remove(currList.size() - 1);
    //             seen.set(i, 0);
    //         }
    //     }
    // }
}