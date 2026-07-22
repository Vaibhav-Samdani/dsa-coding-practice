class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];

        Arrays.fill(pre,1);
        Arrays.fill(suff,1);

        for(int i = 1; i < n;i++){
            pre[i] *= pre[i-1] * nums[i-1];
            suff[n-i-1] *= suff[n-i] * nums[n-i];
        }

        for(int i = 0; i<n;i++){
            nums[i] = pre[i] * suff[i];
        }

        return nums;
    }
}