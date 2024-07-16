class Solution {
    void dfs(int[] nums, int idx, List<Integer> subseq, Set<List<Integer>> hs) {
        if (subseq.size() >= 2) {
            hs.add(new ArrayList<>(subseq));
        }
        for (int i = idx; i < nums.length; i++) {
            if (subseq.size() == 0 || 
            (subseq.size() > 0 && nums[i] >= subseq.get(subseq.size()-1))) {
                subseq.add(nums[i]);
                dfs(nums, i+1, subseq, hs);
                subseq.remove(subseq.size()-1);
            }
            else
                dfs(nums, i+1, subseq, hs);
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> subseq = new ArrayList<>();
        Set<List<Integer>> hs = new HashSet<>();
        int idx = 0;
        dfs(nums, idx, subseq, hs);
        return new ArrayList<>(hs);
    }
}