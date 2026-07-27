class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size() > 2){
                pq.poll();
            }
        }

        int a = pq.poll()-1;
        int b = pq.poll()-1;

        return a*b;
    }
}