class Solution {
	public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
		Set<ArrayList<Integer>> ans = new TreeSet<>((a,b)->Integer.compare(a.get(0),b.get(0)));
		
		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.put(arr[0], 0);
		
		for (int i = 1; i<arr.length; i++) {
			if (mp.containsKey(-arr[i])) {
				ArrayList<Integer> curr = new ArrayList<>();
				if (arr[i] >= 0) {
					curr.add(-arr[i]);
					curr.add(arr[i]);
				}else{
					curr.add(arr[i]);
					curr.add(-arr[i]);
				}
				ans.add(new ArrayList<>(curr));
			}
			mp.put(arr[i], i);
		}
		
		ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
		
		for(ArrayList<Integer> curr : ans){
		    sol.add(new ArrayList<>(curr));
		}
		
		return sol;
	}
}
