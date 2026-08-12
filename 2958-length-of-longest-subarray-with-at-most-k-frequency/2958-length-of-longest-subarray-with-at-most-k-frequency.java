class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (i < j && mp.getOrDefault(nums[j],0) >= k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }

            ans = Math.max(j - i + 1, ans);
            mp.put(nums[j], mp.getOrDefault(nums[j],0) + 1);
        }

        return ans;
    }
}