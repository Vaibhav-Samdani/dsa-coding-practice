class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int i = 0; i<nums.length;i++){
            st.add(nums[i]);
        }
        int ans = 0;
        for(int num : st){
            if(!st.contains(num-1)){
                int curr = num;
                int count = 0;
                while(st.contains(curr)){
                    count++;
                    curr = curr+1; 
                }

                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}