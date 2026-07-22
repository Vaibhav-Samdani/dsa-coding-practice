class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<String> st = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                String rowKey = board[row][col] + "R" + row;
                String colKey = board[row][col] + "C" + col;
                String boxKey = board[row][col] + "B" + (row / 3) + (col / 3);
                if (!st.add(rowKey) || !st.add(colKey) || !st.add(boxKey)) return false;
            }
        }

        return true;
    }
}
