class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int result = 0;

        for(int i = 0; i<n;i++){

            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                int val = st.pop();

                if(st.isEmpty()) break;

                int nge = i;
                int pge = st.peek();

                int width = nge - pge - 1;

                int height = Math.min(arr[nge],arr[pge]) - arr[val];

                result += width * height;

            }

            st.push(i);
        }

        return result;
    }
}