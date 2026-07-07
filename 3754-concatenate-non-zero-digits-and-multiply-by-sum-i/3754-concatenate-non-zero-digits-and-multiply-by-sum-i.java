class Solution {
    public long sumAndMultiply(int n) {
        int num = n;

        int newNum = 0;

        long sum = 0;

        while (num > 0) {
            int last = num % 10;
            num /= 10;
            if (last != 0) {
                newNum = newNum * 10 + last;
                sum += last;
            }
        }
        num = 0;
        while (newNum > 0) {
            int last = newNum % 10;
            newNum /= 10;

            num = num * 10 + last;

        }

        return num * sum;
    }
}