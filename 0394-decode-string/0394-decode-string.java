class Solution {

    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '[') {
                    sb.append(st.pop());
                }
                st.pop();
                // Extract number
                StringBuilder num = new StringBuilder();

                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.append(st.pop());
                }

                num.reverse();

                int n = Integer.parseInt(num.toString());

                // Reverse because characters were popped backwards
                sb.reverse();

                for (int k = 0; k < n; k++) {
                    for (int j = 0; j < sb.length(); j++) {
                        st.push(sb.charAt(j));
                    }
                }
            }

            st.push(ch);
        }

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            char ch = st.pop();
            if(ch == ']') continue;
            ans.append(ch);
        }

        ans.reverse();

        return ans.toString();


    }
}
