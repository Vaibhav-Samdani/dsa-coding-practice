class Solution {
    public int rowWithMax1s(int[][] arr) {
        int ans = -1;
        
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i].length - check(arr[i],0);
            if(count < temp){
                count = temp;
                ans = i;
            }
        }
        
        return ans;
    }
    
    
    int check(int[] arr, int val){
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] <= 0 ){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        
        return low;
    }
    
};