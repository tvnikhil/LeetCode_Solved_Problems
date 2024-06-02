class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int delta = arr[mid] - (mid + 1);
            if (delta < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low + k;
    }
}