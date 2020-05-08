public class confusing_maze {
    static boolean maxTravelUtil(int r, int c, int threshold, int[][] initThickness, long[][] rate, int rows, int cols,
            int count) {
        if (r == rows - 1 && c == cols - 1)
            return true;
        if (c + 1 < cols && rate[r][c + 1] * count + initThickness[r][c + 1] <= threshold) {
            if (maxTravelUtil(r, c + 1, threshold, initThickness, rate, rows, cols, count + 1))
                return true;
        }
        if (r + 1 < rows && rate[r + 1][c] * count + initThickness[r + 1][c] <= threshold) {
            if (maxTravelUtil(r + 1, c, threshold, initThickness, rate, rows, cols, count + 1))
                return true;
        }
        return false;
    }

    static boolean maxTravelUtil2(int r, int c, int threshold, int[][] initThickness, long[][] rate, int rows, int cols,
            int count) {
        if (r >= rows || c >= cols)
            return false;
        if (r == rows - 1 && c == cols - 1)
            return true;

        if (count > threshold)
            return false;
        if (maxTravelUtil2(r, c + 1, threshold, initThickness, rate, rows, cols, count + (int) rate[r][c]))
            return true;
        if (maxTravelUtil2(r + 1, c, threshold, initThickness, rate, rows, cols, count + (int) rate[r][c]))
            return true;
        return false;
    }

    static String mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols) {
        boolean ans = maxTravelUtil2(0, 0, threshold, initThickness, rate, rows, cols, 1);
        return ans ? "YES" : "NO";
    }

    public static void main(String[] args) {
        int[][] initThickness = { { 1, 1, 1 }, { 1, 1, 1 } };
        long[][] rate = { { 1, 1, 1 }, { 1, 1, 1 } };
        int rows = 3;
        int cols = 3;
        int threshold = 5;
        String ans = mazeTraveller(threshold, initThickness, rate, rows, cols);
        System.out.println(ans);
    }
}