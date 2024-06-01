class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] hm = new int[1001];
        for (int i = 0; i < arr.length; i++)
            hm[arr[i]] = 1;
        int cnt = 0, i = 0;
        for (i = 1; i <= 1000; i++) {
            if (hm[i] == 0) cnt++;
            if (cnt == k) return i;
        }
        return k - cnt + i - 1;
    }
}