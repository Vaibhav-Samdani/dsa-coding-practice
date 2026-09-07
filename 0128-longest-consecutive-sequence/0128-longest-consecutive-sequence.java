class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int lastMin = Integer.MIN_VALUE;
        int largestAns = 1;
        int currCount = 0;

        for(int i = 0; i<nums.length;i++){
            if(nums[i]-1 == lastMin){
                currCount++;
                lastMin = nums[i];
            }else if(nums[i] != lastMin){
                currCount = 1;
                lastMin = nums[i];
            }

            largestAns = Math.max(currCount,largestAns);

        }

        return largestAns;
    }
}