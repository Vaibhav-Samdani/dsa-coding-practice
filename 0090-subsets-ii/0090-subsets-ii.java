class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    void solve(int[] nums, int start, List<Integer> curr) {
        // if (start == nums.length) {
            ans.add(new ArrayList<>(curr));
            // return;
        // }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            solve(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
