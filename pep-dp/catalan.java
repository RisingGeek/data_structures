import java.util.*;

class catalan {
    public static void display(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j]);
            System.out.println();
        }
    }

    static int mod = (int) (Math.pow(10, 9) + 7);

    public static long catalanNumber(int n, long[] dp) {
        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != 0)
            return dp[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanNumber(i, dp) * catalanNumber(n - i - 1, dp);
        }
        return dp[n] = ans ;
    }

    public static void main(String[] args) {
        // code
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (int it = 0; it < t; it++) {
            int n = scan.nextInt();
            long[] dp = new long[n + 1];
            long ans = catalanNumber(n, dp);
            System.out.println(ans);
        }
        scan.close();
    }
}