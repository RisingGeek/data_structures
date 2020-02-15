public class n_queens {

    static int calls = 0;
    static int row_size = 10, col_size = 10, queen = 10;

    static int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

    public static boolean isQueenSafe(boolean[][] board, int r, int c) {
        for (int i = 0; i < dir.length; i++) {
            for (int jump = 1; jump < board.length; jump++) {
                int nr = r + jump * dir[i][0];
                int nc = c + jump * dir[i][1];
                if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                    if (board[nr][nc])
                        return false;
                }
            }
        }
        return true;
    }

    public static void n_queens_problem(boolean[][] board, int bn, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        calls++;
        for (int i = bn; i < board.length * board.length; i++) {
            int r = i / board[0].length;
            int c = i % board[0].length;
            if (isQueenSafe(board, r, c)) {
                board[r][c] = true;
                n_queens_problem(board, i + 1, qpsf + 1, tnq, ans + "(" + r + "," + c + ") ");
                board[r][c] = false;
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////

    static boolean[] row = new boolean[row_size];
    static boolean[] col = new boolean[col_size];
    static boolean[] diag = new boolean[row_size + col_size - 1];
    static boolean[] antiDiag = new boolean[row_size + col_size - 1];

    public static boolean isQueenSafeArray(int r, int c) {
        if (row[r] || col[c] || diag[r + c] || antiDiag[r - c + col_size - 1])
            return false;
        return true;
    }

    public static void mark_queen(int r, int c) {
        row[r] = true;
        col[c] = true;
        diag[r + c] = true;
        antiDiag[r - c + col_size - 1] = true;
    }

    public static void unmark_queen(int r, int c) {
        row[r] = false;
        col[c] = false;
        diag[r + c] = false;
        antiDiag[r - c + col_size - 1] = false;
    }

    public static void n_queens_array(int bn, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        calls++;
        for (int i = bn; i < row_size * col_size; i++) {
            int r = i / row_size;
            int c = i % row_size;
            if (isQueenSafeArray(r, c)) {
                mark_queen(r, c);
                n_queens_array(i + 1, qpsf + 1, tnq, ans + "q" + qpsf + "b(" + r + "," + c + ") ");
                unmark_queen(r, c);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////

    static int rowBit = 0;
    static int colBit = 0;
    static int diagBit = 0;
    static int antiDiagBit = 0;

    public static boolean isQueenSafeBit(int r, int c) {
        if ((rowBit & (1 << r)) != 0 || (colBit & (1 << c)) != 0 || (diagBit & (1 << (r + c))) != 0
                || (antiDiagBit & (1 << (r - c + col_size - 1))) != 0)
            return false;
        return true;
    }

    public static void markUnmarkQueenBit(int r, int c) {
        rowBit ^= (1 << r);
        colBit ^= (1 << c);
        diagBit ^= (1 << (r + c));
        antiDiagBit ^= (1 << (r - c + col_size - 1));
    }

    public static void n_queens_bit(int bn, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        calls++;
        for (int i = bn; i < row_size * col_size; i++) {
            int r = i / row_size;
            int c = i % row_size;
            if (isQueenSafeBit(r, c)) {
                markUnmarkQueenBit(r, c);
                n_queens_bit(i + 1, qpsf + 1, tnq, ans + "q" + qpsf + "b(" + r + "," + c + ") ");
                markUnmarkQueenBit(r, c);
            }
        }
    }

    public static void n_queens_bit_best(int row, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return;
        }

        calls++;
        for (int col = 0; col < col_size; col++) {
            if (isQueenSafeBit(row, col)) {
                markUnmarkQueenBit(row, col);
                n_queens_bit_best(row + 1, tnq - 1, ans + "q" + tnq + "b(" + row + "," + col + ") ");
                markUnmarkQueenBit(row, col);
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[row_size][col_size];
        // n_queens_problem(board, 0, 0, queen, "");
        // n_queens_array(0, 0, queen, "");
        // n_queens_bit(0, 0, queen, "");
        n_queens_bit_best(0, queen, "");
        System.out.println(calls);
    }
}