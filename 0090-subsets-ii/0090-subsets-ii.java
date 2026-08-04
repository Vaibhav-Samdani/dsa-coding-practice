class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    void solve(int[] nums, int start, List<Integer> curr) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[start]);
        solve(nums, start + 1, curr);
        curr.remove(curr.size() - 1);

        int j = start + 1;
        while (j < nums.length && nums[j] == nums[start]) j++;

        solve(nums, j, curr);
    }
}
