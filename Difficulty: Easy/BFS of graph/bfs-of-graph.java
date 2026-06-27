class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        
        boolean[] vis = new boolean[n];
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        
        vis[0] = true;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            
            ans.add(temp);
            
            ArrayList<Integer> arr = adj.get(temp);
            
            for(int val : arr){
                if(!vis[val]){
                    q.offer(val);
                    vis[val] = true;
                }
            }
            
        }
        
        return ans;
    }
}