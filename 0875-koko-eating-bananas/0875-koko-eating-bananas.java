import java.util.Arrays;

class Solution {
    public int getMax(int[] arr) {
        int maxi = -1;
        for (int i = 0; i < arr.length; i++)
            maxi = Math.max(maxi, arr[i]);
        return maxi;
    }
    
    public int calculateHours(int[] arr, int div) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += (int) Math.ceil(arr[i] / (double) div);
        }
        return res;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        if (len == 1)
            return (int) Math.ceil(piles[0] / (double) h);
        int maxi = getMax(piles);
        int low = 1, high = maxi, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hoursTaken = calculateHours(piles, mid);
            //System.out.println(hoursTaken + " " + mid);
            if (hoursTaken > 0 && hoursTaken <= h) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}