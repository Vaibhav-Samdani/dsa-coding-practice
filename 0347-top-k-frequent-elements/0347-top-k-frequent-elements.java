class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Method 2 ; HashMap + Min Heap;

        HashMap<Integer, Integer> mp = new HashMap<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->mp.get(a) - mp.get(b));


        for(int el: nums){
            mp.put(el,mp.getOrDefault(el,0)+1);
        }

        for(int val : mp.keySet()){
            minHeap.offer(val);

            if(minHeap.size() > k){
                minHeap.poll();
            }

        }

        int[] ans = new int[k];

        for(int i = 0; i<k;i++){
            ans[i] = minHeap.poll();
        }

        return ans;

    }
}