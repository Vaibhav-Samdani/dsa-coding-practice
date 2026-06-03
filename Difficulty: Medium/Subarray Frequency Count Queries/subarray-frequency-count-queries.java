class Solution {
	public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
		// code here
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
		
		for (int i = 0; i<arr.length; i++) {
			if (mp.containsKey(arr[i])) {
				mp.get(arr[i]).add(i);
			} else {
				ArrayList<Integer> d = new ArrayList<>();
				d.add(i);
				mp.put(arr[i], d);
			}
		}
		
		for (int i = 0; i<queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			int val = queries[i][2];
			
			ArrayList<Integer> l = mp.get(val);
			
			if (l == null) {
				list.add(0);
				continue;
			}

			
			
			int left = lowerBound(l, start); // first position >= start
			int right = upperBound(l, end); // first position > end
			
			int count = right - left;
			list.add(count);
		}
		
		return list;
	}
	
	int lowerBound(ArrayList<Integer> arr, int k) {
		int low = 0;
		int high = arr.size() - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (arr.get(mid) < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return low;
	}
	
	int upperBound(ArrayList<Integer> arr, int k) {
		int low = 0;
		int high = arr.size() - 1;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (arr.get(mid) <= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return low;
	}
}
