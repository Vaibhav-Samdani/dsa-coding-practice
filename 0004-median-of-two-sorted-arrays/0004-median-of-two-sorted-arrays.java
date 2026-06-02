class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int h = m;

        while (l <= h) {
            int Px = l + (h - l) / 2;
            int Py = (m + n + 1) / 2 - Px;

            // Left wale
            int l1 = Px == 0 ? Integer.MIN_VALUE : nums1[Px-1];
            int l2 = Py == 0 ? Integer.MIN_VALUE :nums2[Py-1];

            // Right wale
            int r1 = Px == m ? Integer.MAX_VALUE :nums1[Px];
            int r2 = Py == n ? Integer.MAX_VALUE :nums2[Py];

            if(l1<=r2 && l2 <= r1){
                if( (m + n) % 2 == 1 ){
                    return Math.max(l1,l2);
                }else{
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            }else if(l2>=r1){
                l = Px +1;
            }else{
                h = Px - 1;
            }

        }

        return -1;
    }
}