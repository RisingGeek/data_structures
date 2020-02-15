public class crossword {
    public static boolean[] placeWordH(char[][] board, String word, int x, int y) {
        boolean[] loc = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (board[x][y + i] == '-') {
                loc[i] = true;
                board[x][y + i] = word.charAt(i);
            }
        }

        return loc;
    }

    public static boolean[] placeWordV(char[][] board, String word, int x, int y) {
        boolean[] loc = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (board[x + i][y] == '-') {
                loc[i] = true;
                board[x + i][y] = word.charAt(i);
            }
        }

        return loc;
    }

    public static void unplaceWordH(char[][] board, boolean[] loc, int x, int y) {
        for (int i = 0; i < loc.length; i++) {
            if (loc[i]) {
                board[x][y + i] = '-';
            }
        }
    }

    public static void unplaceWordV(char[][] board, boolean[] loc, int x, int y) {
        for (int i = 0; i < loc.length; i++) {
            if (loc[i]) {
                board[x + i][y] = '-';
            }
        }
    }

    public static boolean canPlaceWordH(char[][] board, int x, int y, String word) {
        //out of the board
        if (y + word.length() > board[0].length)
            return false;

        // + should be present before starting of word
        if (y - 1 >= 0 && board[x][y - 1] != '+')
            return false;

        // + should be present after starting of word 
        if (y + word.length() < board[0].length && board[x][y + word.length()] != '+')
            return false;

        for (int i = 0; i < word.length(); i++) {
            if (board[x][y + i] != '-' && board[x][y + i] != word.charAt(i))
                return false;
        }

        return true;
    }

    public static boolean canPlaceWordV(char[][] board, int x, int y, String word) {
        if (x + word.length() > board.length)
            return false;

        if (x - 1 >= 0 && board[x - 1][y] != '+')
            return false;

        if (x + word.length() < board.length && board[x + word.length()][y] != '+')
            return false;

        for (int i = 0; i < word.length(); i++) {
            if (board[x + i][y] != '-' && board[x + i][y] != word.charAt(i))
                return false;
        }

        return true;
    }

    public static void crosswordProblem(char[][] board, String[] words, int idx) {
        if (idx == words.length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            return;
        }

        String word = words[idx];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    if (canPlaceWordH(board, i, j, word)) {
                        boolean[] loc = placeWordH(board, word, i, j);
                        crosswordProblem(board, words, idx + 1);
                        unplaceWordH(board, loc, i, j);
                    }
                    if (canPlaceWordV(board, i, j, word)) {
                        boolean[] loc = placeWordV(board, word, i, j);
                        crosswordProblem(board, words, idx + 1);
                        unplaceWordV(board, loc, i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = { { '+', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
                { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
                { '-', '-', '-', '-', '-', '-', '-', '+', '+', '-' },
                { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
                { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
                { '-', '+', '+', '+', '+', '-', '-', '-', '-', '-' },
                { '-', '-', '-', '-', '-', '-', '+', '+', '+', '-' },
                { '-', '+', '+', '+', '+', '+', '+', '+', '+', '-' },
                { '+', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

        String[] words = { "CHEMISTRY", "PHYSICS", "HISTORY", "MATHS", "CIVICS", "GEOGRAPHY" };
        crosswordProblem(board, words, 0);
    }
}