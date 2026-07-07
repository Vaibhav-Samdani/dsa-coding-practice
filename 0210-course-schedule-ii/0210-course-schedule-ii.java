class Solution {
    public int[] findOrder(int V, int[][] edg) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edg.length; i++) {
            int u = edg[i][1];
            int v = edg[i][0];

            adj.get(u).add(v);
        }

        Deque<Integer> st = new ArrayDeque<>();
        int[] state = new int[V]; // 0=unvisited,1=visiting,2=visited

        for (int i = 0; i < V; i++) {
            if (state[i] == 0) {
                if (dfs(adj, state, st, i)) {
                    return new int[0];
                }
            }
        }

        int[] ans = new int[V];

        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] state, Deque<Integer> st, int curr) {
        state[curr] = 1;

        for (int neigh : adj.get(curr)) {
            if(state[neigh] == 1){
                return true;
            }
            if (state[neigh] == 0) {
                if(dfs(adj, state, st, neigh)){
                    return true;
                }
            }
        }

        state[curr] = 2;
        st.push(curr);
        return false;
    }

}