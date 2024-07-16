class Solution {
    void dfs(int[] nums, int idx, List<Integer> subseq, List<List<Integer>> ans) {
        if (subseq.size() >= 2) {
            ans.add(new ArrayList<>(subseq));
        }
        Set<Integer> hs = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (hs.contains(nums[i]))
                    continue;
            if (subseq.size() == 0 || 
            (subseq.size() > 0 && nums[i] >= subseq.get(subseq.size()-1))) {
                hs.add(nums[i]);
                subseq.add(nums[i]);
                dfs(nums, i+1, subseq, ans);
                subseq.remove(subseq.size()-1);
            }
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> subseq = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        dfs(nums, idx, subseq, ans);
        return ans;
    }
}