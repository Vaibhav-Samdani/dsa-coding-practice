class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!bfs(graph, colors, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean bfs(int[][] graph, int[] colors, int curr){
        
        Queue<Integer> q = new LinkedList<>();

        q.offer(curr);

        colors[curr] = 0;
        
        while(!q.isEmpty()){
            int val = q.poll();
            int color = 1 - colors[val];
            for(int neigh : graph[val]){
                if(colors[neigh] == -1){
                    q.offer(neigh);
                    colors[neigh] = color;
                }else{
                    if(colors[neigh] == colors[val]) return false;
                }
            
            }
        
        
        }

        return true;
    }

}