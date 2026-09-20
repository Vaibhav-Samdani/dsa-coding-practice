class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1. Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                
            }
        }


        // 2. Reverse; 
        for (int i = 0; i < n; i++) {
            int j = 0, k = n-1;
            while(j<k){
                swap(matrix[i],j,k);
                j++;
                k--;
            }
        }

    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}