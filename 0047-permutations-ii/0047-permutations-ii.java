class Solution {
    public void swap(int a, int b, int[] nums) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
    
    public void helper(int idx, int[] nums, Set<List<Integer>> hs) {
        if (idx >= nums.length) {
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                currList.add(nums[i]);
            hs.add(currList);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            helper(idx+1, nums, hs);
            swap(i, idx, nums);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> hs = new HashSet<>();
        helper(0, nums, hs);
        return new ArrayList<>(hs);
    }
}