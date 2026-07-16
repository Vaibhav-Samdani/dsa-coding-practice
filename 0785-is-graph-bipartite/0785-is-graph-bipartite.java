class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i = 0 ; i<graph.length;i++){
            if(colors[i] == -1){
                if(!helper(graph,colors,i)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean helper(int[][] graph, int[] colors, int curr){
        Queue<Integer> q = new LinkedList<>();

        q.offer(curr);

        colors[curr] = 0;

        while(!q.isEmpty()){
            int val = q.poll();

            for(int neigh : graph[val]){

                if(colors[neigh] != -1){
                    if(colors[neigh] == colors[val]){
                        return false;
                    }
                }else{
                    colors[neigh] = 1 - colors[val];
                    q.offer(neigh);
                }
            }
        }

        return true;
    }
}