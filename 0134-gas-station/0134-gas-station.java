class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumOfGas = 0;
        int sumOfCost = 0;

        for(int i = 0; i<n;i++){
            sumOfGas += gas[i];
            sumOfCost += cost[i];
        }

        if(sumOfGas < sumOfCost) return -1;

        int pref = 0;
        int ans = 0;

        for(int i =0; i<n;i++){
            pref += gas[i] - cost[i];

            if(pref < 0){
                pref = 0;
                ans = i+1;
            }
        }

        return ans;
    }
}
