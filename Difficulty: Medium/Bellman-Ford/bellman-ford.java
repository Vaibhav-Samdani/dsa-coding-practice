class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] result = new int[V];
        Arrays.fill(result,100000000);
        
        result[src] = 0;
        
        for(int i = 0; i < V; i++){
            
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                
                if(result[u] != 100000000 && result[u] + w < result[v]){
                    result[v] = result[u] + w;
                    if(i == V-1){
                        return new int[]{-1};
                    }
                }
            }
        }
        
        return result;
        
    }
}
