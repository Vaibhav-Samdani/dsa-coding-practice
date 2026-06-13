class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();

        // int[][] dp = new int[n-]

        int min = Integer.MAX_VALUE;

        for(int i = n-2;i >= 0; i--){
        int m = arr.get(i).size();
            for(int j = 0; j < m ;j++){
                int val1 = arr.get(i+1).get(j);
                int val2 = arr.get(i+1).get(j+1);
                if(j==0) arr.get(i).set(j,Math.min(val1,val2)+arr.get(i).get(j));
                if(j > 0) {
                    int val3 = arr.get(i+1).get(j-1); 
                    arr.get(i).set(j,Math.min(val1,val2)+arr.get(i).get(j));
                }
            }
        }

        return arr.get(0).get(0);
    }
}