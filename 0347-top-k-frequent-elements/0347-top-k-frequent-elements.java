class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> mp.get(a) - mp.get(b));

        for(int i : mp.keySet()){
            minHeap.offer(i);


            if(minHeap.size() > k){
                minHeap.poll();
            }
        }


        int ans[] = new int[k];
        int p = 0;
        while(!minHeap.isEmpty()){
            ans[p++] = minHeap.poll();
        }

        return ans;
    }
}