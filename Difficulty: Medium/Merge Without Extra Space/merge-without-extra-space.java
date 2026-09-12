class Solution {
    public void mergeArrays(int a[], int b[]) {
        int m = b.length;
        int n = a.length;
        
        for(int i = 0; i<m;i++){
            if(a[n-1] > b[i]){
                int temp = a[n-1];
                a[n-1] = b[i];
                b[i] = temp;
            }
            
            int j = n-2;
            
            while(j >= 0 && a[j] > a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                j--;
            }
        }
        
        Arrays.sort(b);
    }
}
