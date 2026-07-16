class Solution {

    public int maxProduct(int[] nums) {
        int res = nums[0];

        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if(curr < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            minProd = Math.min(curr,minProd * curr);
            maxProd = Math.max(curr,maxProd * curr);

            res = Math.max(res,maxProd);
        }

        return res;
    }
}
