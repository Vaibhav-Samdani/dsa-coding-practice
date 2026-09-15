class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i = 0; i<arr.length;i++){
            mp.put(arr[i],i);
        }
        
        for(int i = 0; i<arr.length;i++){
            for(int j = i + 1; j < arr.length;j++){
                int num3 = target - arr[i] - arr[j];
                if(mp.containsKey(num3) && mp.get(num3) != i && mp.get(num3) != j){
                    return true;
                }
            }
        }
        
        
        return false;
        
    }
}
