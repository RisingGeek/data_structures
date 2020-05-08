class n_knights {
    static int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

    public static boolean isQueenSafe(boolean[][] board, int r, int c) {
        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                if (board[nr][nc])
                    return false;
            }
        }
        return true;
    }

    public static void n_queens_problem(boolean[][] board, int bn, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        // calls++;
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

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        int bn = 0;
        int qpsf = 0;
        int tnq = board.length;
        String ans = "";
        n_queens_problem(board, bn, qpsf, tnq, ans);
    }
}