class leetcode983 {
    static int[] pass = { 1, 7, 30 };

    public static int minCost(int[] days, int[] costs, int idx, int maxDay) {
        if (idx == days.length)
            return 0;

        // if pass is still valid
        if (maxDay >= days[idx]) {
            int mini = minCost(days, costs, idx + 1, maxDay);
            System.out.println(idx + " " + mini);
            return mini;
        }

        int miniCost = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int currCost = minCost(days, costs, idx + 1, days[idx] + pass[i] - 1) + costs[i];
            miniCost = Math.min(miniCost, currCost);
        }

        System.out.println(idx + " " + miniCost);
        return miniCost;
    }

    public static int mincostTickets(int[] days, int[] costs) {
        return minCost(days, costs, 0, 0);
    }

    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        int miniCost = mincostTickets(days, costs);
        System.out.println(miniCost);
    }
}