class Solution {
    class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<Node> qu = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    qu.offer(new Node(i,j));

             }
                if(grid[i][j] == 1) count++;
            }
        }

        int ans = -1;

        if(count == 0) return 0;


        while(!qu.isEmpty()){
            int len = qu.size();

            for(int k = 0; k < len;k++){
                Node val = qu.poll();
                int i = val.i;
                int j = val.j;

                grid[i][j] = 2;
                
                if(i - 1 >= 0 && grid[i-1][j] == 1 ) {
                    grid[i-1][j] =2;
                count--;
                    qu.offer(new Node(i-1,j));
                    }
                if(j - 1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] =2;
                count--;
                    qu.offer(new Node(i,j-1));
                    }
                if(i + 1 < m && grid[i+1][j] == 1) {
                    grid[i+1][j]= 2;
                count--;
                    qu.offer(new Node(i+1,j));
                    }
                if(j + 1 < n && grid[i][j+1] == 1) {
                count--;
                    grid[i][j+1] = 2;
                    qu.offer(new Node(i,j+1));
                    }

            }
            ans++;
        }

        return count == 0 ? ans : -1;
    }
}