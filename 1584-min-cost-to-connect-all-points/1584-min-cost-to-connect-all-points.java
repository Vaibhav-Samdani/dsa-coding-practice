class Solution {

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dis = Math.abs(x2-x1) + Math.abs(y2-y1);

                adj.get(i).add(new Pair(j,dis));
                adj.get(j).add(new Pair(i,dis));
            }
        }

        int minCost = 0;

        // Min Heap;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight,b.weight));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair val = pq.poll();

            if(vis[val.node]) continue;

            vis[val.node] = true;

            minCost += val.weight;

            for(Pair neigh : adj.get(val.node)){
                if(!vis[neigh.node]){
                    pq.offer(neigh);
                }
            }
        }

        return minCost;

    }
}