class Solution {
	public boolean isSubset(int a[], int b[]) {
		
		if (a.length < b.length)
			return false;
		
		Map<Integer, Integer> st = new HashMap<>();
		
		for (int i = 0; i<a.length; i++) {
			st.put(a[i], st.getOrDefault(a[i], 0) + 1);
		}
		
		for (int i = 0; i<b.length; i++) {
			if (!st.containsKey(b[i]) || st.get(b[i]) <= 0) {
				return false;
			}
			
			st.put(b[i], st.get(b[i]) - 1);
		}
		
		return true;
	}
}
