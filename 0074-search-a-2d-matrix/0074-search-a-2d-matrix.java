class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m * n - 1;

        while (i <= j) {
            int mid = i + (j - i)/2;

            int midI = mid / n;
            int midJ = mid % n;

            if(matrix[midI][midJ] == target) return true;
            else if(matrix[midI][midJ] > target) j = mid-1;
            else i = mid+1;


        }

        return false;
    }
}