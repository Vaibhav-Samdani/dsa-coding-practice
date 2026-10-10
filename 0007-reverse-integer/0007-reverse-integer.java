class Solution {
    public int reverse(int x) {
        // int n = Math.abs(x);
        int n = x;

        int ans = 0;
        int rem = 0;
        while(n != 0){
            rem = (n % 10);
            if(ans > (Integer.MAX_VALUE)/10 || ans < (Integer.MIN_VALUE)/10  ) return 0;
            ans = ans * 10 + rem;
            n /= 10;
        } 
        return ans; 
    }
}