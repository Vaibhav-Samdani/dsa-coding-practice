class Solution {
    static{
        int [] ans = new int[]{5,6,7};

        for(int i =0; i< 301;i++){
            maxSlidingWindow(ans,2);
        }
       
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        // Deque is better option here as it is double-ended queue;
        // Can be used as Stack;
        // can also be implemented using LinkedList;

        int ans[] = new int[n-k+1];
        // n-k+1 because k-1 values have no group

        int idx=0;

        for(int i = 0; i<n;i++){

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i] ){
                // Remove last values on the basis of the new value if new value is greater than the prev at last end;
                dq.pollLast();
            }

            while(!dq.isEmpty() && dq.peekFirst() <= i-k ){
                // Remove first element if window exceed the value of k;
                dq.pollFirst();
            }
            
            // add element and back;
            dq.offerLast(i);

            if(i+1 >= k){
                // PeekFirst contains maximum value's index;
                ans[idx] = nums[dq.peekFirst()];
                idx++;
            }

        }

        return ans;

    }
}