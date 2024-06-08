class Solution {
    public int daysToShip(int[] arr, int targetWeight) {
        int days = 1, weight = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + weight <= targetWeight)
                weight += arr[i];
            else {
                days++;
                weight = arr[i];
            }
        }
        return days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = weights[0], ans = -1;
        for (int i = 1; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int shipDays = daysToShip(weights, mid);
            if (shipDays <= days) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}