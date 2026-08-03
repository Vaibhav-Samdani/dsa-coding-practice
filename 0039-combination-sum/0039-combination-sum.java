class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,target,0,new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, int target, int i, List<Integer> curr){
        if (target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(i == nums.length) return;

        // while(i > 0 && nums[i] == nums[i-1]){
        //     i++;
        // }

        curr.add(nums[i]);

        // helper(nums,target-nums[i],i+1,curr);
        helper(nums,target-nums[i],i,curr);

        curr.remove(curr.size()-1);

        helper(nums,target,i+1,curr);

    }
}