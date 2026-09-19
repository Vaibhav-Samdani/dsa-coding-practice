class Solution {
    public int[][] sortedMatrix(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[] temp = new int[m*n];
        
        for(int i = 0; i < m*n;i++){
            int row = i / n;
            int col = i % n;
            
            temp[i] = mat[row][col];
        }
        
        Arrays.sort(temp);
        
        for(int i = 0; i < m*n;i++){
            int row = i / n;
            int col = i % n;
            
            mat[row][col] = temp[i] ;
        } 
        
        return mat;
        
    }
};