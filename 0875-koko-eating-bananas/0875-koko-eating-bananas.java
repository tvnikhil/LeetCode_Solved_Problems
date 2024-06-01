import java.util.Arrays;

class Solution {
    public int getMax(int[] arr) {
        int maxi = -1;
        for (int i = 0; i < arr.length; i++)
            maxi = Math.max(maxi, arr[i]);
        return maxi;
    }
    
    public boolean calculateHours(int[] arr, int div, int h) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.ceil((double) arr[i] / (double) div);
            if (res > h)
                return false;
        }
        return true;
    }
    
    public int sum(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            res += arr[i];
        return res;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int maxi = getMax(piles);
        int low = (int) Math.ceil((double) sum(piles) / (double) h);
        int high = maxi, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean hoursTaken = calculateHours(piles, mid, h);
            if (hoursTaken == false)
                low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}