class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i = 0; i<nums.length;i++){
            maxHeap.offer(nums[i]);
        }

        for(int i = 1; i<k;i++){
            maxHeap.poll();
        }

        return maxHeap.peek();

    }
}