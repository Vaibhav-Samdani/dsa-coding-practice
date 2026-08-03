class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        ans(nums,0,new ArrayList<>());

        return res;
    }

    void ans(int[] nums, int i, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        ans(nums, i + 1, curr);
        curr.remove(curr.size() - 1);

        ans(nums, i + 1, curr);
    }
}