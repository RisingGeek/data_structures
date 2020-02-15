public class landmines {
    public static int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    public static int minAns = Integer.MAX_VALUE;

    public static void mark_unsafe(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int d = 0; d < dir.length; d++) {
                        int nsr = i + dir[d][0];
                        int nsc = j + dir[d][1];
                        if (nsr >= 0 && nsc >= 0 && nsr < board.length && nsc < board[0].length) {
                            board[nsr][nsc] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] board, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return false;
        if (board[r][c] == 0 || visited[r][c])
            return false;
        return true;
    }

    public static void landmines_problem(int[][] board, boolean[][] visited, int r, int c, int count) {
        if (c == board[0].length - 1) {
            minAns = Math.min(minAns, count);
            return;
        }

        if (count > minAns)
            return;
        // System.out.println(count);
        visited[r][c] = true;
        for (int d = 0; d < dir.length; d++) {
            int nsr = r + dir[d][0];
            int nsc = c + dir[d][1];
            if (isSafe(board, visited, nsr, nsc)) {
                landmines_problem(board, visited, nsr, nsc, count + 1);
            }
        }
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int[][] board = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        boolean[][] visited = new boolean[board.length][board[0].length];
        mark_unsafe(board);
        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 1) {
                landmines_problem(board, visited, r, 0, 0);
            }
        }
        System.out.println(minAns);
    }
}