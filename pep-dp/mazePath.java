class mazePath {
    public static int maze(int sr, int sc, int dr, int dc, String ans, int[][] dp) {
        if (sr == dr && sc == dc) {
            return 1;
        }
        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int h = 0, v = 0;
        if (sc + 1 <= dc)
            h = maze(sr, sc + 1, dr, dc, ans + "H", dp);
        if (sr + 1 <= dr)
            v = maze(sr + 1, sc, dr, dc, ans + "V", dp);
        return dp[sr][sc] = h + v;
    }

    public static int maze_tab(int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = 1;
            dp[i][n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    public static int mazeMulti(int sr, int sc, int dr, int dc, int[][] dp) {
        if (sr == dr && sc == dc)
            return 1;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int h = 0, v = 0;
        for (int jump = 1; jump <= dc - sc; jump++) {
            // if (sc + jump <= dc)
            h += mazeMulti(sr, sc + jump, dr, dc, dp);
        }
        for (int jump = 1; jump <= dr - sr; jump++) {
            // if (sc + jump <= dc)
            v += mazeMulti(sr + jump, sc, dr, dc, dp);
        }

        return dp[sr][sc] = h + v;
    }

    public static int mazeMulti_tab(int sr, int sc, int dr, int dc, int[][] dp) {
        for (int i = dr; i >= 0; i--) {
            for (int j = dc; j >= 0; j--) {
                if (i == dr && j == dc) {
                    dp[i][j] = 1;
                    continue;
                }

                int h = 0, v = 0;
                for (int jump = 1; jump <= dc - j; jump++) {
                    h += dp[i][j + jump];
                }
                for (int jump = 1; jump <= dr - i; jump++) {
                    v += dp[i + jump][j];
                }
                dp[i][j] = h + v;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int n = 3;
        // int[][] dp = new int[n][n];
        // int paths = maze(0, 0, n-1, n-1, "", dp);
        // System.out.println(paths);
        // int paths = maze_tab(n);
        // System.out.println(paths);
        int[][] dp = new int[n + 1][n + 1];
        int paths = mazeMulti_tab(0, 0, n - 1, n - 1, dp);
        System.out.println(paths);
    }
}