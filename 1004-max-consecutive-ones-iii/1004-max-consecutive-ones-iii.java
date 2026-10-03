class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}