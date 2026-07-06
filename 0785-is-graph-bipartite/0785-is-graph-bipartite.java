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
                // 1. Already colored:
                //      - Same color -> return false.
                //      - Different color -> continue.
                // 2. Not colored:
                //      - Assign opposite color and run DFS.

                if (colors[neighbor] != -1) {
                    if (colors[neighbor] == colors[val])
                        return false;
                }

                // (1 - colors[val]) --> This will change the color
                // Ex. colors[val] = 1 then for next node 1 - 0 = 1 -> next node's color = 1;
                // And vice versa;
                else if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[val];
                    q.offer(neighbor);
                }
            }
        }

        return true;

    }

}
