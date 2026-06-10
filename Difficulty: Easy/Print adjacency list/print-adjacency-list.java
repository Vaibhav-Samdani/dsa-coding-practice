
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // code here
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 1; i <= V; i++){
            ans.add(new ArrayList<>());
        }
        
        for(int[] p : edges){
            int u = p[0], v = p[1];
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        
        return ans;
    }
}