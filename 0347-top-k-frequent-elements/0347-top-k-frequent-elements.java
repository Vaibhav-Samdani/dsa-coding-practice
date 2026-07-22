class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> st : mp.entrySet()) {
            int freq = st.getValue();
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();

            bucket[freq].add(st.getKey());
        }

        int[] ans = new int[k];

        int idx = 0;

        for(int i = nums.length; i >= 0; i--){
            if(bucket[i] == null) continue;

            for(int j = bucket[i].size()-1; j>=0;j--){
                ans[idx++] = bucket[i].get(j);
            }

            if(idx == k) break;
        }

        return ans;
    }
}
