class Solution {

    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int rev = 'z' - ch + 1;
            ans += ((i+1) * rev);
        }

        return ans;
    }
}
