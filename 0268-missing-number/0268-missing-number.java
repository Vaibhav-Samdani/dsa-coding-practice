class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int realXor = 0;

        for(int i = 0; i < n;i++){
            xor ^= nums[i];
            realXor ^= i;
        }
        realXor ^= n;

        return xor ^ realXor;
    }
}