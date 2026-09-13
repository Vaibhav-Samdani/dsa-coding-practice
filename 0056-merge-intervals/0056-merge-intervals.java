class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        ArrayList<int[]> res = new ArrayList<>();

        int currStart = arr[0][0];
        int currEnd = arr[0][1];

        for(int i = 1; i<arr.length;i++){
            if(currEnd >= arr[i][0]){
                currEnd = Math.max(currEnd,arr[i][1]);
            }else{
                res.add(new int[]{currStart,currEnd});
                currStart = arr[i][0];
                currEnd = arr[i][1];
            }
        }

        res.add(new int[]{currStart,currEnd});
        
        return res.toArray(new int[res.size()][]);
    }
}