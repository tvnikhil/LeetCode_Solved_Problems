class Solution {
    void dfs(int[] nums, int idx, List<Integer> subseq, Set<List<Integer>> hs) {
        if (idx >= nums.length) {
            if (subseq.size() >= 2)
                hs.add(new ArrayList<>(subseq));
            return;
        }
        if (subseq.size() == 0 || (subseq.size() > 0 && 
                                   nums[idx] >= subseq.get(subseq.size()-1))) 
        {
            subseq.add(nums[idx]);
            dfs(nums, idx+1, subseq, hs);
            subseq.remove(subseq.size()-1);
        }
        dfs(nums, idx+1, subseq, hs);
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> subseq = new ArrayList<>();
        Set<List<Integer>> hs = new HashSet<>();
        int idx = 0;
        dfs(nums, idx, subseq, hs);
        return new ArrayList<>(hs);
    }
}