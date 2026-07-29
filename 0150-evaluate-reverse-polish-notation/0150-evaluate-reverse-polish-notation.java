class Solution {
    public int evalRPN(String[] vals) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < vals.length; i++) {
            if (vals[i].equals("+")) {
                int b = st.pop();
                int a = st.pop();
                int ans = a + b;
                st.push(ans);
            } else if (vals[i].equals("-")) {
                int b = st.pop();
                int a = st.pop();
                int ans = a - b;
                st.push(ans);
            } else if (vals[i].equals("*")) {
                int b = st.pop();
                int a = st.pop();
                int ans = a * b;
                st.push(ans);
            } else if (vals[i].equals("/")) {
                int b = st.pop();
                int a = st.pop();
                int ans = a / b;
                st.push(ans);
            } else {
                st.push(Integer.parseInt(vals[i]));
            }
        }

        return st.peek();
    }
}