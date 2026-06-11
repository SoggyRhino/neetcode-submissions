
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // row
        for (char[] row : board) {
            for (int i = 0; i < 9; i++) {
                char c = row[i];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (char[] row : board) {
                char c = row[i];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int k = (i * 3); k < (i * 3) + 3; k++) {
                    for (int l = (j*3); l < (j*3) + 3; l++) {
                        char c = board[k][l];
                        if (c != '.' && !set.add(c)) {
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
