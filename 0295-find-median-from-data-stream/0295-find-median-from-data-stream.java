class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);

        right.offer(left.poll());

        if(right.size() > left.size()){
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if(left.size() == 0) return -1.0;

        if((left.size() + right.size()) % 2 == 1){
            return left.peek();
        }else{
            return (right.peek() + left.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */