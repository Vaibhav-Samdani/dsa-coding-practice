class Solution {
    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int V = n + 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new Pair(v,w));
        }

        int[] vis = new int[V];

        Arrays.fill(vis, Integer.MAX_VALUE);

        vis[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair node = pq.poll();

            int val = node.node;
            int wt = node.weight;

            for(Pair neigh : adj.get(val)){
                if(vis[neigh.node] > wt + neigh.weight){
                    vis[neigh.node] = wt + neigh.weight;
                    pq.offer(new Pair(neigh.node,vis[neigh.node]));
                }
            }

        }

        int ans = 0;

        for(int i = 1; i<V;i++){
            if(vis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(vis[i],ans);
        }

        return ans;
    }
}