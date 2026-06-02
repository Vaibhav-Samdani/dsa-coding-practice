class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0,high=nums.length-1,mid=(low+high)/2;
        while (low<high){
            if (nums[mid+1]==nums[mid]){
                if (mid%2==0)
                    low=mid+1;
                else
                    high=mid-1;
            }   
            else{
                if (mid%2==0)
                    high=mid;
                else
                    low=mid+1;
            }
            mid=(low+high)/2;
        }
        return nums[mid];
    }
}