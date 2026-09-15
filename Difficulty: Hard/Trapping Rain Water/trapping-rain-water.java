class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int ans = 0;
        
        while(i <= j){
            if(arr[i] <= arr[j]){
                if(arr[i] >= leftMax){
                    leftMax = arr[i];
                }else{
                    ans += leftMax - arr[i];
                }
                i++;
            }else{
                if(arr[j] >= rightMax){
                    rightMax = arr[j];
                }else{
                    ans += rightMax - arr[j];
                }
                j--;
            }
        }
        
        return ans;
    }
}
