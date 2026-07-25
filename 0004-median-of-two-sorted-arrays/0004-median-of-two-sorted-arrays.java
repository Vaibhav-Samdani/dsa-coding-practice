class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = 0;
        int r1 = 0;

        int l2 = 0;
        int r2 = 0;

        int low = 0, high = m;
        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;
            l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            r1 = cut1 == m ? Integer.MAX_VALUE : nums1[cut1];

            l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            r2 = cut2 == n ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1) {
                    return (double) Math.max(l1, l2);
                } else {
                    double val = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    return (double) (val);
                }
            } else if (r1 < l2) {
                low = cut1 + 1;
            } else {
                high = cut1 - 1;
            }
        }

        return 0.0;
    }
}
