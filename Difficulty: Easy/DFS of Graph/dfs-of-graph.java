class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[adj.size()];
        Arrays.fill(vis,false);
        
        ArrayList<Integer> ans = new ArrayList<>();
        helper(ans,vis,adj,0);
        return ans;
    }
    
    void helper(ArrayList<Integer> list ,boolean[] vis,ArrayList<ArrayList<Integer>> adj, int i ){
        
        vis[i] = true;
        
        list.add(i);
        
        for(int val : adj.get(i) ){
            if(!vis[val]){
                helper(list,vis,adj,val);
            }
        }
    }
}