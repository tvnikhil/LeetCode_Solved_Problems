class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0, r = k-1, n = arr.length;
        int ans = 0;
        int runningSum = 0;
        for (int i = l; i <= r; i++)
            runningSum += arr[i];
        if (runningSum / k >= threshold)
            ans++;
        while (r < n-1) {
            runningSum -= arr[l];
            l++;
            r++;
            runningSum += arr[r];
            if (runningSum / k >= threshold)
                ans++;
        }
        return ans;
    }
}