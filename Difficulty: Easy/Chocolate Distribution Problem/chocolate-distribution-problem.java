class Solution {
	public int findMinDiff(int arr[], int m) {
		if (m == 0 || arr.length == 0 || m > arr.length) {
			return - 1;
		}
		
		Arrays.sort(arr);
		
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i<arr.length - m + 1; i++) {
			int diff = arr[i + m - 1] - arr[i];
			
			ans = Math.min(ans,diff);
			
		}
		
		return ans;
		
	}
}
