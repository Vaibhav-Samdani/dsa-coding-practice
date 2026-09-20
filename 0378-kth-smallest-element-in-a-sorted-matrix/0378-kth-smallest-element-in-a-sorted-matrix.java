class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i<n;i++){
            low = Math.min(low,matrix[i][0]);
        }
        for(int i = 0; i<n;i++){
            high = Math.max(high,matrix[i][n-1]);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            int required = k-1;

            int freq = countFreq(matrix, mid);

            if(freq <= required){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }

        return low;

    }

    int countFreq(int[][] mat, int mid){
        int ans = 0;

        for(int i = 0; i<mat.length;i++){
            ans += count(mat[i],mid);
        }

        return ans;
    }

    int count(int[] arr, int val){
        int low = 0;
        int high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] <= val){
                low = mid+1;
            }else{
                high = mid-1;
            }


        }
            return low;
    }
}