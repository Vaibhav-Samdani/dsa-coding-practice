class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] vis = new boolean[adj.size() + 1];
        
        q.offer(0);
        
        vis[0] = true;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            
            ans.add(temp);
            
            ArrayList<Integer> arr = adj.get(temp);
            
            for(int i = 0; i < arr.size();i++){
                if(!vis[arr.get(i)]){q.offer(arr.get(i));
                
                vis[arr.get(i)] = true;}
            }
        }
        
        
        return ans;
    }
}