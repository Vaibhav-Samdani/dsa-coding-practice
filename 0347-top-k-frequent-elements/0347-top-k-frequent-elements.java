class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> st : mp.entrySet()) {
            pq.offer(st);
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];

        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
