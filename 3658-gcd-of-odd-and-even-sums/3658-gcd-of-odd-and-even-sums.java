class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOfOdd = n*n;

        int sumOfEven = n * (n+1);

        return gcd(sumOfOdd, sumOfEven);
    }

    int gcd(int x, int y){
        if(x>y) return gcd(y,x);

        if(x == 0) return y;

        return gcd(y%x,x);
    }
}