public class nQueens {
    static int tq = 4;
    public static boolean rowQueen[] = new boolean[tq];
    public static boolean columnQueen[] = new boolean[tq];
    public static boolean diagQueen[] = new boolean[2 * tq - 1];
    public static boolean antiDiagQueen[] = new boolean[2 * tq - 1];

    public static boolean isQueenSafe(int r, int c) {
        if (rowQueen[r] || columnQueen[c] || diagQueen[r + c] || antiDiagQueen[r - c + tq - 1])
            return false;
        return true;
    }

    public static void mark_queen(int r, int c) {
        rowQueen[r] = true;
        columnQueen[c] = true;
        diagQueen[r + c] = true;
        antiDiagQueen[r - c + tq - 1] = true;
    }

    public static void unmark_queen(int r, int c) {
        rowQueen[r] = false;
        columnQueen[c] = false;
        diagQueen[r + c] = false;
        antiDiagQueen[r - c + tq - 1] = false;
    }

    public static int queen2DCombination(int bn, int qpsf, int tnq, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = bn; i < tnq * tnq; i++) {
            int r = i / tnq;
            int c = i % tnq;
            if (isQueenSafe(r, c)) {
                mark_queen(r, c);
                count += queen2DCombination(i + 1, qpsf + 1, tnq, ans + "(" + r + ", " + c + ") ");
                unmark_queen(r, c);
            }
        }

        return count;
    }

    public static int rowQueenBit = 0;
    public static int columnQueenBit = 0;
    public static int diagQueenBit = 0;
    public static int antiDiagQueenBit = 0;

    public static boolean isQueenSafeBit(int r, int c) {
        if (rowQueenBit&(1>>r) || columnQueen[c] || diagQueen[r + c] || antiDiagQueen[r - c + tq - 1])
            return false;
        return true;
    }

    public static void main(String[] args) {

        queen2DCombination(0, 0, 4, "");
    }
}