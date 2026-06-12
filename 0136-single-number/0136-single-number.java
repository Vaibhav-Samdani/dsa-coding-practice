class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int el: nums){
            num ^= el;
        }
        return num;
    }
}