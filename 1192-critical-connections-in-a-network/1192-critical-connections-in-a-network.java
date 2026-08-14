class Solution {
    int timer = 0;
    List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int[] arrival = new int[n];
        int[] lower = new int[n];
        boolean[] vis = new boolean[n];
        
        for(int i =0 ;i<n;i++){
            if(!vis[i]){
                dfs(adj,arrival,lower,vis,i,-1);
            }
        }
        
        return ans;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int[] arrival, int[] lower, boolean[] vis, int curr, int parent){
        arrival[curr] = timer;
        lower[curr] = timer;
        vis[curr] = true;
        
        timer++;
        
        for(int neigh : adj.get(curr)){
            if(neigh == parent) continue;
            if(!vis[neigh]){
                dfs(adj,arrival,lower,vis,neigh,curr);
                lower[curr] = Math.min(lower[curr],lower[neigh]);
                
                if(lower[neigh] > arrival[curr]){
                    List<Integer> currAns = new ArrayList<>();
                    currAns.add(curr);
                    currAns.add(neigh);
                    ans.add(new ArrayList<>(currAns));
                }
            }else{
                lower[curr] = Math.min(lower[curr],arrival[neigh]);
            }
        }
    }
}
