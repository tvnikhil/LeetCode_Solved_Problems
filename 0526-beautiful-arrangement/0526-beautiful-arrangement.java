class Solution {
    void swap(List<Integer> arr, int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }
    
    int dfs(int n, int idx, List<Integer> arr, int cnt) {
        if (idx > n) {
            return cnt+1;
        }
        for (int i = idx; i <= n; i++) {
            if (arr.get(i) % idx == 0 || idx % arr.get(i) == 0) {
                swap(arr, i, idx);
                cnt = dfs(n, idx+1, arr, cnt);
                swap(arr, idx, i);
            }
        }
        return cnt;
    }
    
    public int countArrangement(int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            arr.add(i);
        int cnt = dfs(n, 1, arr, 0);
        return cnt;
    }
}