class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums,0);
        return ans;
    }

    void helper(int[] nums, int start){
        if(start == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i<nums.length;i++){
                curr.add(nums[i]);
            }
            ans.add(curr);
            return;
        }

        for(int i = start; i < nums.length;i++){
            // curr.add(nums[i]);
            reverse(nums,start,i);
            helper(nums,start+1);
            reverse(nums,start,i);
            // helper(nums,i+1);
            // curr.remove(curr.size()-1);

        }
    }

    void reverse(int[] nums,int i, int j){
        if(i==j) return;

        int mid = i + (j-i)/2;
        for(int k = i; k<=mid;k++){
            int temp = nums[k];
            nums[k] = nums[j + i - k];
            nums[j + i - k] = temp;
        }
    }
}