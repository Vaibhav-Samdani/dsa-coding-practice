class Solution {
    public int findGCD(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        for(int i : nums){
            mn = Math.min(mn,i);
            mx = Math.max(mx,i);
        }

        return gcd(mn,mx);
    }

    int gcd(int a, int b){
        if(a == 0) return b;

        return gcd(b%a,a);
    }
}