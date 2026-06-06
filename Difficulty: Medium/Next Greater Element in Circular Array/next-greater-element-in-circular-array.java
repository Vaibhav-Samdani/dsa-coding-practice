class Solution {
	public ArrayList<Integer> nextGreater(int[] arr) {
		int n = arr.length;
		
		Stack<Integer> st = new Stack<>();
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int j = 2*n - 2; j >= 0; j--) {
			int i = j % n;
			while (!st.isEmpty() && arr[i] >= st.peek()) {
				st.pop();
			}
			
			if (j < n){
			    if(!st.isEmpty() && st.peek() > arr[i]){
			        ans.add(0,st.peek());
			    }else{
			        ans.add(0,-1);
			    }
			}
			
			st.push(arr[i]);
			
			
		}
		
		return ans;
	}
}
