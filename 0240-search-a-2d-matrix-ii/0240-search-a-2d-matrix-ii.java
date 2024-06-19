class Solution {
    public int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target)
                high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target)
                low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
        
    public boolean searchMatrix(int[][] matrix, int target) {
        int right = floor(matrix[0], target);
        if (right == -1)
            return false;
        int left = ceil(matrix[matrix.length - 1], target);
        if (left == -1)
            return false;
        for (int j = left; j <= right; j++) {
            int[] arr = new int[matrix.length];
            for (int i = 0; i < arr.length; i++)
                arr[i] = matrix[i][j];
            int check = floor(arr, target);
            if (check != -1 && matrix[check][j] == target)
                return true;
        }
        return false;
    }
}