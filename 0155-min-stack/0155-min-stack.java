class MinStack {
    Stack<Integer> arr;
    Stack<Integer> min;

    public MinStack() {
        arr = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int value) {
        arr.push(value);
        if(min.isEmpty() || min.peek() >= value){
            min.push(value);
        }
    }
    
    public void pop() {
        int val = arr.pop();
        if(min.peek() == val){
            min.pop();
        }
    }
    
    public int top() {
        return arr.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */