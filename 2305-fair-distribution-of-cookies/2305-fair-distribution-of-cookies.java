class Solution {
    void dfs(int[] cookies, int idx, List<Integer> sums, int limit, int[] ans) {
        //System.out.println(sums);
        if (idx >= cookies.length) {
            ans[0] = Math.min(ans[0], sums.get(sums.size()-1));
            return;
        }
        for (int i = 0; i < sums.size()-1; i++) {
            if (sums.get(i) < limit) {
                int prevVal = sums.get(i);
                int val = prevVal+cookies[idx];
                int prevMax = sums.get(sums.size()-1);
                sums.set(sums.size()-1, Math.max(val, sums.get(sums.size()-1)));
                sums.set(i, val);
                dfs(cookies, idx+1, sums, limit, ans);
                sums.set(i, prevVal);
                sums.set(sums.size()-1, prevMax);
            }
            else
                continue;
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        int total = 0;
        for (int i = 0; i < cookies.length; i++)
            total += cookies[i];
        int limit = (int) Math.ceil(total/(double) 2);
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < k; i++)
            sums.add(0);
        sums.add(-1);
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(cookies, 0, sums, limit, ans);
        return ans[0];
    }
}