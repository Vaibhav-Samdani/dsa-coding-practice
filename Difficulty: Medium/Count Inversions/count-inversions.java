class Solution {
    static int count;
    static int inversionCount(int arr[]) {
        count = 0;
        mergeSort(arr,0,arr.length-1);
        return count;
    }
    
    static int[] mergeSort(int arr[], int start, int end){
        if(start == end){
            return new int[]{arr[start]};
        }
        
        int mid = start + (end - start)/2;
        
        int[] left = mergeSort(arr,start,mid);
        int[] right = mergeSort(arr,mid+1,end);
        
        return merge(left,right);
    }
    
    static int[] merge(int[] left,int right[]){
        int i = 0, j = 0, k = 0;
        
        int[] arr = new int[left.length + right.length];
        
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
             }else{
                count += left.length - i;
                arr[k++] = right[j++];
             }
        }
        
        while(i < left.length){
            arr[k++] = left[i++];
        }
        while(j < right.length){
            arr[k++] = right[j++];
        }
        
        return arr;
    }
}