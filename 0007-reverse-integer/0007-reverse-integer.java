class Solution {
    public int reverse(int x) {
        long n = Math.abs(x);

        long ans = 0;

        while(n > 0){
            int rem = (int)(n % 10);
            ans = ans * 10 + rem;
            n /= 10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0; 
        return x < 0 ? (int)-ans : (int)ans; 
        

    }
}