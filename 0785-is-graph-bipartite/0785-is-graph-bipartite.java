class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        Arrays.fill(colors,-1);

        for(int i = 0; i<graph.length;i++){
            if(colors[i] == -1){
                if(!dfs(graph,colors,i,0)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(int[][] graph, int[] colors, int curr, int color){
        colors[curr] = color;

        for(int neigh : graph[curr]){
            if(colors[neigh] == -1){
                if(!dfs(graph,colors,neigh,1-color)){
                    return false;
                }
            }else{
                if(colors[neigh] == color) return false;
            }
        }

        return true;
    }






    
}