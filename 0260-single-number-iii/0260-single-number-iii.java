class Solution {
    public int[] singleNumber(int[] nums) {
        // We can use xor as each number can cancel out which appears twice in the array;
        int n = nums.length;
        int xor = 0;

        for(int i = 0; i < n; i++){
            xor ^= nums[i];
        }

        int b = xor & -xor;

        int b1 = 0, b2 = 0;

        for(int i : nums){
            if((i & b) == b){
                b1 ^= i;
            }else{
                b2 ^= i;
            }
        }

        return new int[]{b1,b2};
    }
}