class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int count = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int j = 0; j < n; j++) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            // No of Distinct element -> mp.size()

            while (mp.size() > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }

            count += j - i + 1;
        }

        return count;
    }
}