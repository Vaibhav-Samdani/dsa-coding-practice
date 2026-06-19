class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curralt = 0;
        for(int i = 0; i<gain.length;i++){
            curralt = curralt+gain[i];
            max = Math.max(max,curralt);
        } 

        return max;

    }
}