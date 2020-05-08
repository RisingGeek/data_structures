// import java.util.Arrays;

public class mcm {
    public static void display(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }

    public static int matrix(int st, int end, int[] arr, int[][] dp) {
        if (st + 1 == end)
            return dp[st][end] = 0;

        if (dp[st][end] != -1)
            return dp[st][end];

        int minCost = Integer.MAX_VALUE;
        for (int cut = st + 1; cut < end; cut++) {
            int leftAns = matrix(st, cut, arr, dp);
            int rightAns = matrix(cut, end, arr, dp);
            minCost = Math.min(minCost, leftAns + arr[st] * arr[cut] * arr[end] + rightAns);
        }

        return dp[st][end] = minCost;
    }

    public static int matrix2(int[] arr, int[][] dp) {
        for (int gap = 1; gap < arr.length; gap++) {
            for (int st = 0, end = gap; end < arr.length; st++, end++) {
                if (st + 1 == end) {
                    dp[st][end] = 0;
                    continue;
                }

                int minCost = Integer.MAX_VALUE;
                for (int cut = st + 1; cut < end; cut++) {
                    int leftAns = dp[st][cut];
                    int rightAns = dp[cut][end];
                    minCost = Math.min(minCost, leftAns + arr[st] * arr[cut] * arr[end] + rightAns);
                }

                dp[st][end] = minCost;
            }
        }

        return dp[0][arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };
        int[][] dp = new int[arr.length][arr.length];
        // for (int[] row : dp)
        // Arrays.fill(row, -1);
        // int minCost = matrix(0, arr.length - 1, arr, dp);
        int minCost = matrix2(arr, dp);
        System.out.println(minCost);
        display(dp);
    }
}