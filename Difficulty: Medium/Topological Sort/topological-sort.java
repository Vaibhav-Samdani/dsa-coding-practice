class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int[] indeg = new int[V];
        
        for(int i = 0; i < edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            indeg[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i<V;i++){
            if(indeg[i]==0) q.offer(i);
        }
        
        
        while(!q.isEmpty()){
            int temp = q.poll();
            
            ans.add(temp);
            
            for(int neigh : adj.get(temp)){
                indeg[neigh]--;
                if(indeg[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }
        return ans;
        
    }
}