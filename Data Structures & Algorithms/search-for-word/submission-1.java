
class Solution {

    record Position(int i, int j) {
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (rec(board, word, i, j, word.length() - 1))
                    return true;

        return false;
    }

    public boolean rec(char[][] board, String word, int i, int j, int pos) {
        if (pos < 0)
            return true;


        //bounds check 
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;

        char c = word.charAt(pos);

        //System.out.printf("i: %d j: %d expect: %c found: %c\n", i ,j ,c, board[i][j]);

        if (board[i][j] != c)
            return false;

        // set current pos to garbage so we dont need to handle multi use
        c = board[i][j];
        board[i][j] = '[';

        if (rec(board, word, i - 1, j, pos - 1)) {
            board[i][j] = c;
            return true;
        }

        //right
        if (rec(board, word, i + 1, j, pos - 1)) {
            board[i][j] = c;
            return true;
        }

        //up
        if (rec(board, word, i, j - 1, pos - 1)) {
            board[i][j] = c;
            return true;
        }

        //down
        if (rec(board, word, i, j + 1, pos - 1)) {
            board[i][j] = c;
            return true;
        }

        board[i][j] = c;
        return false;
    }
}
