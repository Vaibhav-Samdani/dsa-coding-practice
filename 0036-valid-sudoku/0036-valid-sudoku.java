class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> st = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.')
                    continue;

                if (st.contains(board[row][col]))
                    return false;

                st.add(board[row][col]);
            }
        }
        for (int row = 0; row < 9; row++) {
            Set<Character> st = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                if (board[col][row] == '.')
                    continue;

                if (st.contains(board[col][row]))
                    return false;

                st.add(board[col][row]);
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Character> st = new HashSet<>();

                for (int row = boxRow; row < boxRow + 3; row++) {
                    for (int col = boxCol; col < boxCol + 3; col++) {

                        if (board[row][col] == '.')
                            continue;

                        if (st.contains(board[row][col]))
                            return false;

                        st.add(board[row][col]);
                    }
                }
            }
        }

        return true;

    }
}
