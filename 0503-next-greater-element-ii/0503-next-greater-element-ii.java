class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[n];
        for (int j = (n * 2 - 2); j >= 0; j--) {
            int i = j % n;
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            if (j < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(arr[i]);

        }

        

        return ans;
    }
}