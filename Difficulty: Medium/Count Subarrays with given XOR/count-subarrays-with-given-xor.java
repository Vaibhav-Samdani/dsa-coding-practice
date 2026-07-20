class Solution {
    public long subarrayXor(int arr[], int k) {
        int ans = 0;
        int prefixXor = 0;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        mp.put(0,1);
        
        for(int i = 0; i < arr.length;i++){
            prefixXor ^= arr[i];
            
            int check = prefixXor ^ k;
            
            if(mp.containsKey(check)){
                ans += mp.get(check);
            }
            
            mp.put(prefixXor, mp.getOrDefault(prefixXor,0)+1);
        }
        
        return ans;
        
    }
}