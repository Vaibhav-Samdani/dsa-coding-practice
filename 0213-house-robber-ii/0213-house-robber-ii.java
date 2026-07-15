class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n + 2];

        int firstVal = helper(dp, nums, 0, n - 2);

        Arrays.fill(dp, 0);

        int secondVal = helper(dp, nums, 1, n - 1);

        return Math.max(firstVal, secondVal);
    }

    int helper(int[] dp, int[] nums, int i, int end) {
        // int[] dp = new int[nums.length+2];
        int next1 = 0;
        int next2 = 0;
        for (int j = end; j >= i; j--) {

            int curr = Math.max(nums[j] + next2, next1);

            next2 = next1;
            next1 = curr;

        }

        return next1;
    }
}
