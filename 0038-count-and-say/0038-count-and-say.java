class Solution {

    public String countAndSay(int n) {
        StringBuilder st = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            StringBuilder curr = new StringBuilder();
            int count = 1;
            for (int j = 1; j < st.length(); j++) {
                if(st.charAt(j) == st.charAt(j-1)){
                    count++;
                }else{
                   curr.append(count);
                   curr.append(st.charAt(j-1));
                   count = 1;
                }
            }

            curr.append(count);
            curr.append(st.charAt(st.length()-1));

            st = curr;
        }

        return st.toString();
    }
}
