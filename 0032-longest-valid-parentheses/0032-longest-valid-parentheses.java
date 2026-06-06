class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        st.push(-1);

        int len = 0;

        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    int val = i - st.peek();
                    len = Math.max(val,len);
                }
            }
        }

        return len;
    }
}