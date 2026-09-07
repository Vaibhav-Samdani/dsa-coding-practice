class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int ans = 0;

        for(int i = 1; i < arr.length;i++){
            arr[i] += arr[i-1];
        }

        for(int i = 0; i<arr.length;i++){

            if(mp.containsKey(arr[i] - k)){
                ans += mp.get(arr[i]-k);
            }

            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        return ans;
    }
}