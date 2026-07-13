class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        int noL = (int) Math.log10(low) + 1;
        int noH = (int) Math.log10(high) + 1;

        for (int len = noL; len <= noH; len++) {

            int maxStart = 10 - len;

            for (int start = 1; start <= maxStart; start++) {

                int val = 0;
                int k = start;

                for (int j = 0; j < len; j++) {
                    val = val * 10 + k;
                    k++;
                }

                if (val >= low && val <= high) {
                    ans.add(val);
                }
            }
        }

        return ans;
    }
}