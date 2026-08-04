class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, 0, new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, int target, int i, List<Integer> curr) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == nums.length) return;
        if (target < 0) return;

        curr.add(nums[i]);

        // helper(nums,target-nums[i],i+1,curr);
        helper(nums, target - nums[i], i + 1, curr);

        curr.remove(curr.size() - 1);

        int j = i + 1;

        while (j < nums.length && nums[j] == nums[i]) j++;

        helper(nums, target, j, curr);
    }
}
