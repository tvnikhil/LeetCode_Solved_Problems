class Solution {
    void generate (int k, int n, int numsTaken, int cSum, 
                  List<Integer> curr, 
                  List<List<Integer>> ans) {
        if (cSum == n && numsTaken == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (numsTaken == k)
            return;
        if (cSum > n)
            return;
        int last = 1;
        if (curr.size() != 0)
            last = curr.get(curr.size()-1) + 1;
        for (int i = last; i <= 9; i++) {
            curr.add(i);
            generate(k, n, numsTaken+1, cSum+i, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n > 45)
            return ans;
        List<Integer> l = new ArrayList<>();
        int numsTaken = 0;
        generate(k, n, numsTaken, 0, l, ans);
        return ans;
    }
}