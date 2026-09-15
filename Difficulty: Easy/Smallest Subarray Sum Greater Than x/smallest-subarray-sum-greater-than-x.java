class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        
        int i = 0;
        
        for(int j = 0; j<arr.length;j++){
            sum += arr[j];
            
            while(sum > x){
                sum -= arr[i];
                
                ans = Math.min(ans,j-i+1);
                
                i++;
            }
        }
        
        return ans == Integer.MAX_VALUE ?0:ans;
        
    }
}
