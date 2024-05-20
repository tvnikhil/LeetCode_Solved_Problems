class Solution {
    public int findMin(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //System.out.println(mid);
            if (arr[low] <= arr[mid] && arr[mid + 1] <= arr[high])
                return Math.min(arr[low], arr[mid + 1]);
            else if (arr[low] <= arr[mid])
                low = mid;
            else
                high = mid;
        }
        return 0;
    }
}