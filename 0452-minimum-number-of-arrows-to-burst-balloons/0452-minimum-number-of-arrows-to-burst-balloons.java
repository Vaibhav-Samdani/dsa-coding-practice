class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int start = points[0][0];
        int end = points[0][1];

        int n = points.length;

        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                n--;
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }else{
                start = points[i][0];
                end = points[i][1];
            }
        }

        return n;

    }
}