import java.util.*;

class booleanParentheses {
    public static void display(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j]);
            System.out.println();
        }
    }

    public static class pair {
        long tCount, fCount;

        public pair(long tCount, long fCount) {
            this.tCount = tCount;
            this.fCount = fCount;
        }
    }

    public static pair getCounts(pair left, pair right, char opr) {
        pair sub = new pair(0, 0);
        if (opr == '&') {
            sub.tCount += left.tCount * right.tCount;
            sub.fCount += (left.tCount + left.fCount) * (right.tCount + right.fCount) - (left.tCount * right.tCount);
        }
        if (opr == '|') {
            sub.fCount += left.fCount * right.fCount;
            sub.tCount += (left.tCount + left.fCount) * (right.tCount + right.fCount) - (left.fCount * right.fCount);
        }
        if (opr == '^') {
            sub.tCount += left.fCount * right.tCount + left.tCount * right.fCount;
            sub.fCount += left.tCount * right.tCount + left.fCount * right.fCount;
        }

        return sub;
    }

    public static pair booleanParen(boolean[] symbol, char[] operator, int st, int end, pair[][] dp) {
        if (st == end) {
            boolean ans = symbol[st];
            return dp[st][end] = new pair(ans ? 1 : 0, !ans ? 1 : 0);
        }

        int mod = 1003;
        // if (st + 1 == end) {
        // boolean ans = operation(symbol[st], symbol[end], operator[st]);
        // return dp[st][end] = new pair(ans ? 1 : 0, !ans ? 1 : 0);
        // }

        if (dp[st][end] != null)
            return dp[st][end];

        pair ans = new pair(0, 0);
        for (int cut = st; cut < end; cut++) {
            pair left = booleanParen(symbol, operator, st, cut, dp);
            pair right = booleanParen(symbol, operator, cut + 1, end, dp);

            // System.out.print(st+" "+end+": ");
            // System.out.println(left.tCount+","+left.fCount+"
            // "+right.tCount+","+right.fCount);
            pair sub = getCounts(left, right, operator[cut]);
            ans.tCount += sub.tCount;
            ans.fCount += sub.fCount;
            ans.tCount = ans.tCount % mod;
            ans.fCount = ans.fCount % mod;
        }

        return dp[st][end] = ans;
    }

    public static void main(String[] args) {
        // code

        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (long it = 0; it < t; it++) {
            int n = Integer.parseInt(scan.nextLine());
            n = n / 2 + 1;
            String str = scan.nextLine();

            boolean[] symbol = new boolean[n];
            char[] operator = new char[n - 1];
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (i % 2 == 0) {
                    symbol[idx1] = (ch == 'T') ? true : false;
                    idx1++;
                } else {
                    operator[idx2] = ch;
                    idx2++;
                }
            }
            pair[][] dp = new pair[n][n];
            pair ans = booleanParen(symbol, operator, 0, n - 1, dp);
            System.out.println(ans.tCount);
        }
        scan.close();
    }
}