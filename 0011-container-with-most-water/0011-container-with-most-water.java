class Solution {

    public int maxArea(int[] nums) {
        int max = 0;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int val = (j - i) * Math.min(nums[j], nums[i]);
            max = Math.max(val, max);
            if (i <= j && nums[j] < nums[i]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
