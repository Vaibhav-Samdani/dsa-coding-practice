class Solution {
	boolean[][] board;
	ArrayList<ArrayList<Integer>> ans;
	public ArrayList<ArrayList<Integer>> nQueen(int n) {
		board = new boolean[n][n];
		ans = new ArrayList<>();
		solve(n, 0, 0, new ArrayList<>());
		return ans;
	}
	
	void solve(int n, int i, int j, ArrayList<Integer> curr) {
		if (n <= 0) {
			ans.add(new ArrayList<>(curr));
			return;
			
		}
		
		if (i >= board.length)
			return;
		if (j == board.length) {
			return;
		}
		
		if (canPlace(i, j)) {
			board[i][j] = true;
			curr.add(j + 1);
			solve(n - 1, i + 1, 0, curr);
			board[i][j] = false; // backtrack
			curr.remove(curr.size() - 1); // backtrack
			
			solve(n, i, j + 1, curr); // try next column
		} else {
			solve(n, i, j + 1, curr);
		}
		
	}
	
	boolean canPlace(int i, int j) {
		
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		
		for (int k = i; k >= 0; k--) {
			if (board[k][j]) {
				return false;
			}
		}
		int x = i;
		int y = j;
		
		while (x >= 0 && y < board[0].length) {
			if (board[x][y]) {
				return false;
			}
			x--;
			y++;
		}
		
		x = i;
		y = j;
		
		while (x >= 0 && y >= 0) {
			if (board[x][y]) {
				return false;
			}
			x--;
			y--;
		}
		
		return true;
	}
}
