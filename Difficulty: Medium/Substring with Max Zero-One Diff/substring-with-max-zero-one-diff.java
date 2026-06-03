class Solution {
    int maxSubstring(String s) {
        
        int curr = 0;
        int max = -1;
        
        for(char ch : s.toCharArray()){
            
            if(ch == '1'){
                curr--;
            }
            if(ch == '0'){
                curr++;
            }
            
            max = Math.max(curr,max);
            
            if(curr < 0) {
                curr = 0;
            }
            
        }
        
        return max;
        
    }
}