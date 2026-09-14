class Solution {
	class Pair {
		int val;
		int idx;
		int arr;
		Pair(int val, int idx, int arr) {
			this.val = val;
			this.idx = idx;
			this.arr = arr;
		}
	}
	public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
		// code here
		int i = 0, j = 0, k = 0;
		
		Set<Integer> ans = new TreeSet<>();
		
		while (i<a.length && j<b.length && k<c.length) {
			PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->Integer.compare(x.val, y.val));
			
			pq.offer(new Pair(a[i], i, 1));
			pq.offer(new Pair(b[j], j, 2));
			pq.offer(new Pair(c[k], k, 3));
			
			if (a[i] == b[j] && b[j] == c[k]) {
				ans.add(a[i]);
				i++;
				j++;
				k++;
			} else {
				Pair val = pq.poll();
				
				if (val.arr == 1) {
					i++;
				} else if (val.arr == 2) {
					j++;
				} else {
					k++;
				}
			}
		}
		return new ArrayList<>(ans);
		
	}}
