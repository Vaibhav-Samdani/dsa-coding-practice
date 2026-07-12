class Solution {
    public ArrayList<Integer> DSU(int n, int[][] queries) {
       ArrayList<Integer> ans = new ArrayList<Integer>();
       int m = n+1;
       int[] parent = new int[m];
       
       for(int i = 0; i<m;i++){
           parent[i] = i;
       }
       
       for(int i = 0; i < queries.length;i++){
           if(queries[i][0] == 1){
               int x = queries[i][1];
               int z = queries[i][2];
               
               union(x,z, parent);
           }else{
               int x = queries[i][1];
               ans.add(find(x,parent));
           }
       }
       
       return ans;
        
    }
    
    int find(int i,int[] parent){
        if(i == parent[i]) return i;
        
        return parent[i] = find(parent[i],parent);
    }
    
    // void union(int x, int y, int[] parent, int[] rank){
    //     int x_parent = find(x,parent);
    //     int y_parent = find(y,parent);
        
    //     if(x_parent == y_parent) return;
        
    //     if(rank[x_parent] > rank[y_parent]){
    //         parent[y_parent] = x_parent;
         
    //     }
    //     else if(rank[x_parent] < rank[y_parent]){
    //         parent[x_parent] = y_parent;
    //     }else{
    //         parent[x_parent] = y_parent;
    //         rank[y_parent]++;
    //     }
        
      
    // }
    void union(int x, int z, int[] parent) {
    int px = find(x, parent);
    int pz = find(z, parent);

    if (px != pz) {
        parent[px] = pz;
    }
}
}
