class Solution {
    
    // int lcs(int idx1, int idx2, String s1, String s2, List<List<Integer>> dp) {
    //     if (idx1 < 0 || idx2 < 0)
    //         return 0;
    //     if (dp.get(idx1).get(idx2) != -1)
    //         return dp.get(idx1).get(idx2);
    //     if (s1.charAt(idx1) == s2.charAt(idx2)) {
    //         dp.get(idx1).set(idx2, 1+lcs(idx1-1, idx2-1, s1, s2, dp));
    //         return dp.get(idx1).get(idx2);
    //     }
    //     dp.get(idx1).set(idx2, Math.max(lcs(idx1-1, idx2, s1, s2, dp), lcs(idx1, idx2-1, s1, s2, dp)));
    //     return dp.get(idx1).get(idx2);
    // }
    
    public int longestCommonSubsequence(String s1, String s2) {
        List<List<Integer>> dp = new ArrayList<>();
        int m = s1.length(), n = s2.length();
        for (int i = 0; i < m; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                dp.get(i).add(-1);
            }
        }
        
        for (int idx1 = 0; idx1 < m; idx1++) {
            for (int idx2 = 0; idx2 < n; idx2++) {
                if (s1.charAt(idx1) == s2.charAt(idx2)) {
                    if (idx1-1>=0 && idx2-1>=0)
                        dp.get(idx1).set(idx2, 1+dp.get(idx1-1).get(idx2-1));
                    else
                        dp.get(idx1).set(idx2, 1);
                }
                else {
                    int case1 = 0, case2 = 0;
                    if (idx1-1>=0)
                        case1 = dp.get(idx1-1).get(idx2);
                    if (idx2-1>=0)
                        case2 = dp.get(idx1).get(idx2-1);
                    dp.get(idx1).set(idx2, Math.max(case1, case2));
                }
            }
        }
        
        return dp.get(m-1).get(n-1);
        
        // return lcs(m-1, n-1, s1, s2, dp);
    }
}