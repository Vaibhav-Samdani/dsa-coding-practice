class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n;i++){
            int val = b + a;
            a = b;
            b = val;
        }

        return b;
    }

}