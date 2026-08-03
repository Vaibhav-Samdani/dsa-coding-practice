class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
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

        for (int j = i; j < nums.length; j++) {
            if (target < 0) {
                return;
            }
            curr.add(nums[j]);
            helper(nums, target - nums[j], j, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
