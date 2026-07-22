class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        int[] ans = new int[2];

        for(int i = 0; i < nums.length;i++){
            int val = target - nums[i];

            if(mp.containsKey(val)){
                ans[0] = i;
                ans[1] = mp.get(val);
                break;
            }
            mp.put(nums[i],i);
        }

        return ans;
    }
}