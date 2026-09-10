class Solution {
    public void reverseArray(int arr[]) {
        int i = 0;
        int j = arr.length-1;
        
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    
    void swap(int[]arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}