class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if(nums[0] > x && nums[n-1] > x){
            return -1;
        }
        int i = 0;

        int sum = 0;

        for (i = 0; i < n; i++) {
            sum += nums[i];
        }

        

        i = 0;

        int diff = sum - x;

        int slidingSum = 0;

        int sumLen = -1;

        for (int j = 0; j < n; j++) {
            slidingSum += nums[j];

            while (i < n && slidingSum > diff) {
                slidingSum -= nums[i];
                i++;
            }

            if (slidingSum == diff) {
                int curr = j - i + 1;
                sumLen = Math.max(sumLen,curr);
            }
        }

        return sumLen == -1 ? -1 : n - sumLen;
    }
}