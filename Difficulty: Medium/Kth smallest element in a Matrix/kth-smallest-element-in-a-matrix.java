class Solution {
	public int kthSmallest(int[][] mat, int k) {
		int n = mat.length;
		int m = mat[0].length;
		
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		
		for (int i = 0; i<n; i++) {
			low = Math.min(mat[i][0], low);
		}
		for (int i = 0; i<n; i++) {
			high = Math.max(mat[i][m - 1], high);
		}
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			int freq = count(mat, mid);
			
			int required = k-1;
			
			if (freq <= required) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return low;
		
	}
	
	int count(int[][] mat, int mid) {
		int ans = 0;
		for (int i = 0; i<mat.length; i++) {
			ans += countSmaller(mat[i], mid);
		}
		
		return ans;
	}
	
	int countSmaller(int[] mat, int val) {
		int low = 0;
		int high = mat.length - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			
			if (val >= mat[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return low;
	}
}
