public class coin {
    public static void coin_infinite_combination(int[] coins, int idx, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                coin_infinite_combination(coins, i, tar - coins[i], ans + coins[i]);
            }
        }
    }

    public static void coin_permutation(int[] coins, boolean[] visited, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0 && !visited[i]) {
                visited[i] = true;
                coin_permutation(coins, visited, tar - coins[i], ans + coins[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        // coin_infinite_combination(coins, 0, 10, "");
        boolean[] visited = new boolean[coins.length];
        coin_permutation(coins, visited, 10, "");
    }
}