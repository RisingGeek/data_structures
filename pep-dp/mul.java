import java.util.Arrays;

public class mul {
    public static void display(pair[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j].maxAns + " ");
            System.out.println();
        }
    }

    public static class pair {
        int maxAns;
        String ans;

        public pair() {
            maxAns = -1;
            ans = "";
        }

        public pair(int maxAns, String ans) {
            this.maxAns = maxAns;
            this.ans = ans;
        }
    }

    public static pair matrix(int st, int end, int[] arr, pair[][] dp) {
        if (st + 1 == end)
            return dp[st][end] = new pair(0, "" + (char)(st + 'A'));

        if (dp[st][end].maxAns != -1)
            return dp[st][end];

        int minCost = Integer.MAX_VALUE;
        pair p = new pair();
        for (int cut = st + 1; cut < end; cut++) {
            pair leftAns = matrix(st, cut, arr, dp);
            pair rightAns = matrix(cut, end, arr, dp);

            int newAns = leftAns.maxAns + arr[st] * arr[cut] * arr[end] + rightAns.maxAns;
            if (newAns < minCost) {
                minCost = newAns;
                p.ans = "(" + leftAns.ans + rightAns.ans + ")";
            }
        }
        p.maxAns = minCost;

        return dp[st][end] = p;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 3 };
        pair[][] dp = new pair[arr.length][arr.length];
        for (pair[] row : dp)
            Arrays.fill(row, new pair());
        pair minCost = matrix(0, arr.length - 1, arr, dp);
        System.out.println(minCost.ans);
        display(dp);
    }
}