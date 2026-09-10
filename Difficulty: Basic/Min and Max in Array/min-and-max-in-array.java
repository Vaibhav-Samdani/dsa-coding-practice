class Solution {
	public ArrayList<Integer> getMinMax(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (arr.length == 0)
			return ans;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i<arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		ans.add(min);
		ans.add(max);
		
		return ans;
	}
}
