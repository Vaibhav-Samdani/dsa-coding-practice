class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        int[] indeg = new int[V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            
            indeg[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int cnt = 0;
        
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int u = q.poll();
            
            cnt++;
            for(int i : adj.get(u)){
                indeg[i]--;
                if(indeg[i] == 0){
                    q.offer(i);
                }
            }
        }
        
        return !(cnt == V);
        
    }
}