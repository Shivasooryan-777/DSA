public class LC36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }

                int val = ch - '1'; // 0 to 8
                int bit = 1 << val;
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check for duplicates in row, column, or 3x3 box
                if ((rows[r] & bit) != 0 || (cols[c] & bit) != 0 || (boxes[boxIndex] & bit) != 0) {
                    return false;
                }

                rows[r] |= bit;
                cols[c] |= bit;
                boxes[boxIndex] |= bit;
            }
        }

        return true;
    }
}
