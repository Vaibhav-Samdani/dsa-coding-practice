class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(piles[i], high);
        }

        high++;

        int ans = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                ans = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isPossible(int[] piles, int h, int mid) {
        int i = 0;

        while (i < piles.length) {
            if (piles[i] < mid) {
                h--;
            } else {
                int val = piles[i] / mid;
                int k = piles[i] % mid == 0 ? piles[i] / mid : piles[i] / mid + 1;

                h -= k;
            }
            i++;
        }
        return h >= 0;
    }
}
