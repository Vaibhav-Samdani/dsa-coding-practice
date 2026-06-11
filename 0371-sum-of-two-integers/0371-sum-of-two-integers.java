class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0) {
            int tempSum = sum;
            sum ^= carry;
            carry = (tempSum & carry) << 1;
        }

        return sum;
    }
}