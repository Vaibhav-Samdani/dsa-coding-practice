class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = m * n - 1;

        while(i<=j){
            int mid = i + (j-i)/2;

            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;

            else if(matrix[row][col] < target) i = mid + 1;
            else if(matrix[row][col] > target) j = mid - 1;
        }

        return false;
    }
}
