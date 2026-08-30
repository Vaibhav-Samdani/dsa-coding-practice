class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;

        for(int i = 0; i<n;i++){
            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }
        }

        if(minIdx > maxIdx){
            int temp = minIdx;
            minIdx = maxIdx;
            maxIdx = temp;
        }


        minIdx++;
        maxIdx++;

        int first = minIdx + (n-maxIdx +1);
        int second = (n-minIdx + 1);
        int third = maxIdx;

        return Math.min(first,Math.min(second,third));

    }
}