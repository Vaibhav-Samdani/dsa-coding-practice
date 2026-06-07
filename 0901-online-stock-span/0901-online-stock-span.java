class StockSpanner {

    class Node {
        int val;
        int span;

        Node(int val, int span) {
            this.val = val;
            this.span = span;
        }
    }

    Stack<Node> st;

    public StockSpanner() {
        st = new Stack<>();
      
    }

    public int next(int price) {

        int span = 1;
       
        while (!st.isEmpty() && st.peek().val <= price) {
            span += st.pop().span;
        }
        
        st.push(new Node(price, span));
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */