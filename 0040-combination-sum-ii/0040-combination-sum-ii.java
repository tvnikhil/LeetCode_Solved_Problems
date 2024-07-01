class Solution {
    public void comboSum (int[] arr, int x, int idx, List<Integer> subSet, List<List<Integer>> ans) {
        if (x == 0) {
            ans.add(new ArrayList<>(subSet));
            return;
        }
        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > x) break;
            if (arr[i] == prev) continue;
            subSet.add(arr[i]);
            comboSum(arr, x - arr[i], i+1, subSet, ans);
            subSet.remove(subSet.size() - 1);
            prev = arr[i];
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] arr, int x) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        comboSum(arr, x, 0, new ArrayList<>(), ans);
        return ans;
    }
}