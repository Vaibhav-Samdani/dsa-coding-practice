class Solution {

    public boolean isBipartite(int[][] graph) {

        // 0  -> Red;
        // 1  -> Green;
        // -1 -> Uncolored;        
        int[] colors = new int[graph.length];

        Arrays.fill(colors, -1);

        for(int i =0; i<graph.length;i++){
            if(colors[i] == -1){
                if(!bfs(graph,colors,i)){
                    return false;
                }
            }
        }
        return true;

    }

    boolean bfs(int[][] graph, int[] colors, int curr){
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(curr);
        colors[curr] = 0;

        while (!q.isEmpty()) {
            int val = q.poll();

            for (int neighbor : graph[val]) {

                if (colors[neighbor] != -1) {
                    if (colors[neighbor] == colors[val])
                        return false;
                }

                else if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[val];
                    q.offer(neighbor);
                }
            }
        }

        return true;

    }

}
