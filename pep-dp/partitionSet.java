class partitionSet {
    public static int partition(int n, int k, int[][] dp) {
        if (k > n)
            return 0;
        if (k <= 1 || k == n)
            return 1;

        if (dp[n][k] != 0)
            return dp[n][k];

        int makeNewSet = partition(n - 1, k - 1, dp);
        int includeInAnySet = partition(n - 1, k, dp);

        return dp[n][k] = makeNewSet + includeInAnySet * k;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[][] dp = new int[n + 1][k + 1];
        int ways = partition(n, k, dp);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ways);
    }
}