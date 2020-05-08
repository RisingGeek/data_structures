import java.util.Arrays;

class board_path {
    public static int boardPathMemo(int start, int end, int[] jumps, int[] dp) {
        if (start == end)
            return 1;

        if (dp[start] != -1)
            return dp[start];
        int paths = 0;
        for (int i = 0; i < jumps.length; i++) {
            if (start + jumps[i] <= end) {
                paths += boardPathMemo(start + jumps[i], end, jumps, dp);
            }
        }
        return dp[start] = paths;
    }

    public static int boardPathTab(int start, int end, int[] jumps, int[] dp) {
        for (int i = end; i >= start; i--) {
            if (i == end) {
                dp[i] = 1;
                continue;
            }

            int paths = 0;
            for (int j = 0; j < jumps.length; j++) {
                if (i + jumps[j] <= end) {
                    paths += dp[i + jumps[j]];
                }
            }
            dp[i] = paths;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int start = 0, end = 10;
        int[] jumps = { 1, 2, 3, 4, 5, 6 };
        int[] dp = new int[end + 1];
        Arrays.fill(dp, -1);

        // int paths = boardPathMemo(start, end, jumps, dp);
        int paths = boardPathTab(start, end, jumps, dp);
        System.out.println(paths);
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}