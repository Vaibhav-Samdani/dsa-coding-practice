class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> st = new HashSet<>();
        long curr = 0;
        int i = 0;
        long ans = 0;
        for(int j = 0; j < nums.length;j++){

            while(st.contains(nums[j])){
                st.remove(nums[i]);
                curr -= nums[i];
                i++;
            }

            st.add(nums[j]);
            curr += nums[j];

            while(j-i+1 > k){
                st.remove(nums[i]);
                curr -= nums[i];
                i++;
            }

            if(j-i+1 == k){
                ans = Math.max(ans,curr);
            }

        }

        return ans;
    }
}