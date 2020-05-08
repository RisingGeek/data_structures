class palindromic_subsequence {
    public static int[][] isPalindromicSubsequence(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int gap = 0; gap < str.length(); gap++) {
            for (int si = 0, ei = gap; ei < str.length(); si++, ei++) {
                if (gap == 0)
                    dp[si][ei] = 1;
                else if (gap == 1 && str.charAt(si) == str.charAt(ei))
                    dp[si][ei] = 1;
                else if (str.charAt(si) == str.charAt(ei) && dp[si + 1][ei - 1] == 1)
                    dp[si][ei] = 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str = "babad";
        int[][] dp = isPalindromicSubsequence(str);
        for (int[] row : dp) {
            for (int el : row)
                System.out.print(el+" ");
            System.out.println();
        }
    }
}