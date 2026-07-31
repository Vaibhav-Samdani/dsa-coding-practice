class Solution {

    class Pair {
        int x;
        int y;
        long dis;

        Pair(int x, int y, long dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            pq.offer(new Pair(x,y,distanceSq(x,y)));
        }
        
        for(int i = 0; i<k ;i++){
            Pair val = pq.poll();

            ans[i][0] = val.x;
            ans[i][1] = val.y;
        }
        
        return ans;
    }

    long distanceSq(int x, int y) {
        return 1L * x * x + 1L * y * y;
    }
}
