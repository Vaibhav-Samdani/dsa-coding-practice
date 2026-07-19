class Solution {
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        solve(s, new ArrayList<>(), 0);
        return ans;
    }

    void solve(String s, List<String> temp, int i) {
        if (s.length() == i) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int k = i; k < s.length(); k++) {
            String rem = s.substring(i, k + 1);

            if (check(rem)) {
                temp.add(rem);
                solve(s, temp, k + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean check(String s) {
        if (s.length() == 1) return true;

        for (int i = 0; i < s.length() / 2; i++) {
            char A = s.charAt(i);
            char B = s.charAt(s.length() - i - 1);
            if (A != B) return false;
        }

        return true;
    }
}
