class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        String st = s.toLowerCase();

        while (i < j) {
            
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            char left = st.charAt(i);
            char right = st.charAt(j);

            if (left != right) return false;

            i++;
            j--;
        }

        return true;
    }
}
