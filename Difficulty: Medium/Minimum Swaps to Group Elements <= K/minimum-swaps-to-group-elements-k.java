class Solution {
	int minSwap(int[] arr, int k) {
		
		
		int count = 0;
		
		for (int i = 0; i<arr.length; i++) {
			if(arr[i] <= k) count++;
		}
		
		int bad = 0;

        for (int i = 0; i < count; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }

        int ans = bad;
        
        
        for(int i = count; i < arr.length;i++){
            if(arr[i] > k) bad++;
            
            if(arr[i-count] > k) bad--;
            
            
            ans = Math.min(ans,bad);
        }
        
        return ans;
		
		
	}
}
