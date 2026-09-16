class Solution {
    public static boolean isPalinArray(int[] arr) {
        for(int i = 0; i<arr.length;i++){
            if(!isPal(arr[i])) return false;
        }
        
        return true;
    }
    
    static boolean isPal(int num){
        String n = Integer.toString(num);
        
        int i = 0; 
        int j = n.length()-1;
        
        while(i<j){
            if(n.charAt(i) != n.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}