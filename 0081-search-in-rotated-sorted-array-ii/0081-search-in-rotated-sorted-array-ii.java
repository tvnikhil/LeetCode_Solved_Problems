class Solution {
    public boolean search(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
                low++; high--;
                continue;
            }
            if (arr[mid] <= arr[high]) {
                //right sorted
                if (target >= arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else {
                //left sorted
                if (target >= arr[low] && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return false;
    }
}