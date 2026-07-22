class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<String> st = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                String s = board[row][col] + " @ " + "i = " + row;
                String s2 = board[row][col] + " @ " + "j = " + col;
                String s3 = board[row][col] + " @ " + "i = " + row / 3 + " j = " + col / 3;
                if (!st.add(s) || !st.add(s2) || !st.add(s3)) return false;
            }
        }

        return true;
    }
}
