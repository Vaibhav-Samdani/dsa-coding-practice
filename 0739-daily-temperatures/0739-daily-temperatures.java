class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        int k = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[k--] = 0;
            } else {
                ans[k--] = st.peek()-i;
            }

            st.push(i);
        }

        return ans;
    }
}