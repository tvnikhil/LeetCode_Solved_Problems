class Solution {
    public void swap(int[][] arr, int r1, int c1, int r2, int c2) {
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // reverse columns
        for (int i = 0; i < n; i++) {
            int p1 = 0, p2 = n - 1;
            while (p1 < p2) {
                swap(matrix, p1, i, p2, i);
                p1++;
                p2--;
            }
        }
        // transpose
        for (int i = 0; i < n; i++) {
            int cl = i + 1;
            while (cl < n) {
                swap(matrix, i, cl, cl, i);
                cl++;
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}