import java.util.ArrayList;

public class sudoku {
    public static void initialize(int[][] board, int[] row, int[] col, int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num != 0) {
                    int mask = 1 << num;
                    row[i] |= mask;
                    col[j] |= mask;
                    mat[i / 3][j / 3] |= mask;
                }
            }
        }
    }

    public static void sudoku_solver(int[][] board, int[] row, int[] col, int[][] mat, int bn) {
        if (bn == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        int i = bn / 9;
        int j = bn % 9;
        if (board[i][j] == 0) {
            for (int num = 1; num <= 9; num++) {
                int mask = 1 << num;
                // isSafe
                if ((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {
                    // mark
                    board[i][j] = num;
                    row[i] |= mask;
                    col[j] |= mask;
                    mat[i / 3][j / 3] |= mask;

                    // call
                    sudoku_solver(board, row, col, mat, bn + 1);

                    // unmark
                    board[i][j] = 0;
                    row[i] &= ~mask;
                    col[j] &= ~mask;
                    mat[i / 3][j / 3] &= ~mask;
                }
            }
        } else {
            sudoku_solver(board, row, col, mat, bn + 1);
        }
    }

    public static void initialize2(int[][] board, int[] row, int[] col, int[][] mat, ArrayList<Integer> zeroBn) {

        int bn = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num != 0) {
                    int mask = 1 << num;
                    row[i] |= mask;
                    col[j] |= mask;
                    mat[i / 3][j / 3] |= mask;
                } else {
                    zeroBn.add(bn);
                }
                bn++;
            }
        }
    }

    public static void sudoku_solver2(int[][] board, int[] row, int[] col, int[][] mat, ArrayList<Integer> zeroBn,
            int idx) {
        if (idx == zeroBn.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        int i = zeroBn.get(idx) / 9;
        int j = zeroBn.get(idx) % 9;
        if (board[i][j] == 0) {
            for (int num = 1; num <= 9; num++) {
                int mask = 1 << num;
                // isSafe
                if ((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {
                    // mark
                    board[i][j] = num;
                    row[i] |= mask;
                    col[j] |= mask;
                    mat[i / 3][j / 3] |= mask;

                    // call
                    sudoku_solver(board, row, col, mat, idx + 1);

                    // unmark
                    board[i][j] = 0;
                    row[i] &= ~mask;
                    col[j] &= ~mask;
                    mat[i / 3][j / 3] &= ~mask;
                }
            }
        } else {
            sudoku_solver(board, row, col, mat, idx + 1);
        }
    }

    public static void main(String[] args) {
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        int[] row = new int[9];
        int[] col = new int[9];
        int[][] mat = new int[3][3];

        // initialize(board, row, col, mat);
        // sudoku_solver(board, row, col, mat, 0);

        ArrayList<Integer> zeroBn = new ArrayList<>();
        initialize2(board, row, col, mat, zeroBn);
        sudoku_solver2(board, row, col, mat, zeroBn, 0);
    }
}