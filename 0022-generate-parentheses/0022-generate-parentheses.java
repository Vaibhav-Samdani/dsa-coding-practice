class Solution {

    List<String> ans;

    public List<String> generateParenthesis(int n) {
        Stack<Character> st = new Stack<>();
        ans = new ArrayList<>();

        solve(n,0,0, st);

        return ans;
    }

    void solve(int n, int open, int close, Stack<Character> st) {
        if (close == n && open == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : st) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            st.push('(');
            solve(n,open+1,close,st);
            st.pop();
        }

        if(close < open){
            st.push(')');
            solve(n,open,close+1,st);
            st.pop();
        }
        
        
    }
}
