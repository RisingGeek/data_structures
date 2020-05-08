class pairPeople {
    public static int pair(int p, int[] dp) {
        if (p <= 1)
            return dp[p] = 1;
        if (dp[p] != 0)
            return dp[p];

        int count = 0;
        count += pair(p - 1, dp);
        count += pair(p - 2, dp) * (p - 1);

        return dp[p] = count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        int ways = pair(n, dp);
        System.out.println(ways);
    }
}