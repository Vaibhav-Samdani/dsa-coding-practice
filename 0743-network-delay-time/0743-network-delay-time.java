class Solution {

    class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int nd, int wt) {
            this.node = nd;
            this.weight = wt;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int networkDelayTime(int[][] times, int n, int src) {
        // Dijkstra's name is more difficult than his algorithm........
        int V = n + 1;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        int result[] = new int[V];

        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        minHeap.offer(new Pair(src, 0));

        result[src] = 0;

        while (!minHeap.isEmpty()) {
            Pair val = minHeap.poll();

            int node = val.node;
            int weight = val.weight;

            if(result[node] < weight){
                continue;
            }

            for (Pair neigh : adj.get(node)) {
                if (weight + neigh.weight < result[neigh.node]) {
                    result[neigh.node] = weight + neigh.weight;
                    minHeap.offer(new Pair(neigh.node, result[neigh.node]));
                }
            }
        }
        int max = -1;

        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE ) {
                return -1;
            }
            max = Math.max(max, result[i]);
        }
        return max;
    }
}