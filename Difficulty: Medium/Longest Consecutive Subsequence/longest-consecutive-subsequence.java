class Solution {
    public int longestConsecutive(int[] arr) {
        int max = 0;
        
        for(int i = 0; i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        
        int[] count = new int[max+1];
        
        for(int i = 0; i<arr.length;i++){
            count[arr[i]]++;
        }
        
        int curr = 0;
        int ans = 0;
        for(int i = 0; i<count.length;i++){
            if(count[i] > 0){
                curr++;
            }else{
                curr = 0;
            }
            ans = Math.max(curr,ans);
        }
        
        return ans;
    }
}