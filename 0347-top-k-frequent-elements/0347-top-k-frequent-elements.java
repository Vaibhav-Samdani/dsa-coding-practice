class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> st : mp.entrySet()) {
            pq.offer(st);
        }

        int[] ans = new int[k];

        int n = k;

        while(!pq.isEmpty() && k > 0){
            ans[n-k] = pq.poll().getKey();
            k--;
        }

        return ans;
    }
}
