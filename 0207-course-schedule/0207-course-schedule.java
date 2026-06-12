class Solution {
    public boolean canFinish(int V, int[][] edg) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[V];

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i<V;i++){
            adj.add(new ArrayList<>());
        }


        for(int i = 0; i < edg.length; i++){
            int u = edg[i][1];
            int v = edg[i][0];

            indeg[v]++;

            adj.get(u).add(v);
        }

        for(int i = 0; i<V; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;

            for(int i : adj.get(curr)){
                indeg[i]--;
                if(indeg[i] == 0){
                    q.offer(i);
                }
            }

        }

        return (cnt == V);
    }


}