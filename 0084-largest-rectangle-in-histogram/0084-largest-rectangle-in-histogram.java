class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int val = st.pop();

                int nse = i;

                int pse = st.isEmpty() ? -1 : st.peek();

                result = Math.max(result, heights[val] * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int val = st.pop();

            int nse = heights.length;

            int pse = st.isEmpty() ? -1 : st.peek();

            result = Math.max(result, heights[val] * (nse - pse - 1));

        }

        return result;
    }
}