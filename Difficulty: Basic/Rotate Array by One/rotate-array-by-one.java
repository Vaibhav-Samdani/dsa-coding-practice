class Solution {
    public void rotate(int[] arr) {
        int n = arr.length;
        if(n==0 || n==1) return; 
        int next = arr[n-1];
        for(int i = n-2; i>=0;i--){
            // next = arr[i+1];
            arr[i+1] = arr[i]; 
        }
        
        arr[0] = next;
    }
}