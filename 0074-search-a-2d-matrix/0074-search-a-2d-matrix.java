class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int possibleRow = -1, low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] > target)
                high = mid - 1;
            else {
                possibleRow = mid;
                low = mid + 1;
            }
        }
        if (possibleRow == -1)
            return false;
        low = 0;
        high = matrix[possibleRow].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[possibleRow][mid] == target)
                return true;
            else if (matrix[possibleRow][mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}