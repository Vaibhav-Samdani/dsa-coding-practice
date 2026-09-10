class Solution {
    public void sort012(int[] arr) {
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        
        while(j <= k){
            if(arr[j] == 1){
                j++;
            }
            else if(arr[j] == 0){
                swap(arr,i,j);
                i++;
                j++;
            }
            
            else if(arr[j] == 2){
                swap(arr,j,k);
                k--;
            }
            
        }
    }
    
    void swap(int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}