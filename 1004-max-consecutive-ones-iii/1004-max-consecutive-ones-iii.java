class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;

        if(k == 0){
            int curr = 0;
            for(int j = 0; j < nums.length;j++){
                if(nums[j] == 0){
                    curr = 0;
                }else{
                    curr++;
                }
                ans = Math.max(curr,ans);
            }

            return ans;
        }

        int i = 0;

        for(int j = 0; j<nums.length;j++){

            if(nums[j] == 0) k--;

            while(i < j && k < 0){
                if(nums[i] == 0) k++;
                i++;
            }

            ans = Math.max(ans,j-i+1);
        }

        return ans;
    }
}