class Solution {
    public ArrayList<ArrayList<Integer>> comboSum (int[] arr, int idx, int target,
    int sum, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> ans) {
        if (idx >= arr.length && sum != target) return ans;
        if (sum == target) ans.add(new ArrayList<Integer>(subSet));
        if (sum > target) return ans;
        if (sum < target) {
            subSet.add(arr[idx]);
            sum += arr[idx];
            ans = comboSum(arr, idx, target, sum, subSet, ans);
            sum -= subSet.get(subSet.size() - 1);
            subSet.remove(subSet.size() - 1);
            ans = comboSum(arr, idx + 1, target, sum, subSet, ans);
        }
        return ans;
    }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subSet = new ArrayList<>();
        ans = comboSum(arr, 0, target, 0, subSet, ans);
        return new ArrayList<>(ans);
    }
}