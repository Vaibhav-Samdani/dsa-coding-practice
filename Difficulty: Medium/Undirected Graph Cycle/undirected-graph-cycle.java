class Solution {
    boolean cycle = false;
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i =0; i<V;i++){
            if(!vis[i]){
                
        helper(adj,-1,i,vis);
            }
        }
        
        
        return cycle;
        
        
    }
    
    void helper(ArrayList<ArrayList<Integer>> adj, int parent, int curr, boolean[]  vis){
        vis[curr] = true;
        
        
        for(int i = 0 ; i < adj.get(curr).size();i++){
            int node = adj.get(curr).get(i);
            
            if(!vis[node]){
                helper(adj,curr,node,vis);
            }else if(node != parent){
                cycle = true;
                
            }
        }
        
        
    }
}