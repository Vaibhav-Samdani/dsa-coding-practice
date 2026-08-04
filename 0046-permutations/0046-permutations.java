class Solution {
    List<List<Integer>> ans;
    Set<Integer> st;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        st = new HashSet<>();
        helper(nums, new ArrayList<>());
        return ans;
    }

    void helper(int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st.contains(nums[i])) {
                curr.add(nums[i]);
                st.add(nums[i]);
                helper(nums, curr);
                curr.remove(curr.size() - 1);
                st.remove(nums[i]);
            }
        }
    }

}