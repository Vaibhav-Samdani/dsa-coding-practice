class Solution {
		int count;
	public int inversionCount(int arr[]) {
		count = 0;
		mergeSort(arr,0,arr.length-1);
		
		return count;
	}
	
	int[] merge(int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		int[] ans = new int[left.length + right.length];
		
		while (i<left.length && j < right.length) {
			if (left[i] <= right[j]) {
				ans[k++] = left[i++];
			} else {
				ans[k++] = right[j++];
				count += left.length-i;
			}
		}
		
		while (i<left.length) {
			ans[k++] = left[i++];
			
		}
		while (j<right.length) {
			ans[k++] = right[j++];
			
		}
		
		return ans;
		
	}
	
	int[] mergeSort(int[] arr, int i, int j) {
	    if (i >= j) {
    return new int[]{arr[i]};
}
		int mid = i + (j - i)/2;
		
		int[] left = mergeSort(arr, i, mid);
		int[] right = mergeSort(arr, mid + 1, j);
		
		return merge(left, right);
		
	}
}
