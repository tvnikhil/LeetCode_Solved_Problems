class Solution {
    public boolean makeBouquets(int[] arr, int m, int k, int days) {
        int cnt = 0, bouquetsCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (bouquetsCnt >= m) return true;
            if (arr[i] <= days) cnt++;
            else {
                bouquetsCnt += cnt / k;
                cnt = 0;
            }
        }
        if (cnt > 0) bouquetsCnt += cnt / k;
        return (bouquetsCnt >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if (k * m > bloomDay.length) return -1;
        int mini = bloomDay[0], maxi = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini, high = maxi, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean flag = makeBouquets(bloomDay, m, k, mid);
            if (flag == false) low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}