class Solution {
    public void generateCombos(int n, int k, int currEle, 
                               List<Integer> combo, List<List<Integer>> ans) {
        if (combo.size() == k) {
            ans.add(new ArrayList<>(combo));
            return;
        }
        if (currEle > n)
            return;
        combo.add(currEle);
        generateCombos(n, k, currEle+1, combo, ans);
        combo.remove(combo.size() - 1);
        generateCombos(n, k, currEle+1, combo, ans);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        generateCombos(n, k, 1, combo, ans);
        return ans;
    }
}