class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        boolean isZero = false;
        boolean secondZero = false;

        for(int i = 0; i<nums.length;i++){
            mul *= nums[i] != 0 ? nums[i] : 1;
            if(nums[i] == 0){
                if(isZero){
                    secondZero = true;
                }
                isZero = true;
            }
        }

        for(int i = 0; i < nums.length;i++){
            if(isZero){
                if(nums[i] != 0){
                    nums[i] = 0;
                }
                else if(secondZero){
                    nums[i] = 0;
                }else{
                    nums[i] = mul;
                }
            }else{
                nums[i] = mul/nums[i];
            }
        }

        return nums;
    }
}