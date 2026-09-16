class Solution {
    // Function to partition the array around the range such
    // that array is divided into three parts.
    public void threeWayPartition(int arr[], int a, int b) {
        int i = 0, j = 0, k = arr.length-1;
        
        while(j <= k){
            if(arr[j] < a){
                swap(arr,i,j);
                i++;
                j++;
            }else if(arr[j] >= a && arr[j] <= b){
                j++;
            }else{
                swap(arr,j,k);
                k--;
            }
        }
    }
    
    void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}