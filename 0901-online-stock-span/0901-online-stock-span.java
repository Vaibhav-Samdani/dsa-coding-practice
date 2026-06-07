class StockSpanner {

    class Node {
        int val;
        int idx;

        Node(int val, int i) {
            this.val = val;
            this.idx = i;
        }
    }

    Stack<Node> st;
    int curr;

    public StockSpanner() {
        st = new Stack<>();
        curr = 0;
    }

    public int next(int price) {
       
        while (!st.isEmpty() && st.peek().val <= price) {
            st.pop();
        }
        // Node prevNode = st.peek();
        int span;
        if (st.isEmpty()) {
            span = curr + 1;
        } else {
            span = curr - st.peek().idx + 1;
        }
        st.push(new Node(price, curr + 1));
        curr++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */