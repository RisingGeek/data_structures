class OptimalBst {
    public static int rangeSum(int[] freq, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += freq[i];
        }
        return sum;
    }

    public static int OBst(int[] keys, int[] freq, int start, int end, int[][] dp) {
        if (dp[start][end] != 0)
            return dp[start][end];

        int minCost = Integer.MAX_VALUE;
        int sum = rangeSum(freq, start, end);
        for (int cut = start; cut <= end; cut++) {
            int left = (cut == start) ? 0 : OBst(keys, freq, start, cut - 1, dp);
            int right = (cut == end) ? 0 : OBst(keys, freq, cut + 1, end, dp);

            minCost = Math.min(minCost, left + right);
        }
        return dp[start][end] = minCost + sum;
    }

    public static void main(String[] args) {
        int[] keys = { 10, 12, 20 };
        int[] freq = { 34, 8, 50 };
        int n = keys.length;
        int[][] dp = new int[n][n];
        int cost = OBst(keys, freq, 0, n - 1, dp);
        System.out.println(cost);
    }
}