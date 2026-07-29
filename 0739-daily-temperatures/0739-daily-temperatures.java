class Solution {

    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && temps[st.peek()] <= temps[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return ans;
    }
}
