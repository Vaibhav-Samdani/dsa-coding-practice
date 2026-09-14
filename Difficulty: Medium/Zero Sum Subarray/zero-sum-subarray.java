class Solution {
	public boolean subArrayExists(int arr[]) {
		// code here
		HashSet<Integer> st = new HashSet<>();
		
		st.add(0);
		
		for (int i = 0; i<arr.length; i++) {
			arr[i] += (i == 0)? 0 : arr[i - 1];
			if (st.contains(arr[i])) {
				return true;
			}
			
			st.add(arr[i]);
		}
		
		return false;
	}
}
