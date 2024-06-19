class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix[0].length - 1, right = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[0][mid] > target)
                high = mid - 1;
            else {
                right = mid;
                low = mid + 1;
            }
        }
        if (right == -1)
            return false;
        int left = -1;
        low = 0; 
        high = matrix[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[matrix.length - 1][mid] < target)
                low = mid + 1;
            else {
                left = mid;
                high = mid - 1;
            }
        }
        if (left == -1)
            return false;
        for (int j = left; j <= right; j++) {
            low = 0; high = matrix.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[mid][j] == target)
                    return true;
                else if (matrix[mid][j] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return false;
    }
}