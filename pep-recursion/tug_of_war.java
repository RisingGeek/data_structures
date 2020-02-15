public class tug_of_war {

    public static int minDiff = Integer.MAX_VALUE;

    public static void tugOfWar(int[] arr, int idx, int count, int totSum, int currSum, int k, boolean[] visited,
            int[] subset1, int[] subset2) {
        if (count == k) {
            int subsetSum1 = currSum;
            int subsetSum2 = totSum - subsetSum1;
            int diff = Math.abs(subsetSum1 - subsetSum2);
            if (diff < minDiff) {
                minDiff = diff;
                int index1 = 0, index2 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (visited[i] == true) {
                        subset1[index1] = arr[i];
                        index1++;
                    }

                    else {
                        subset2[index2] = arr[i];
                        index2++;
                    }
                }
            }
            return;
        }

        if (idx == arr.length)
            return;

        visited[idx] = true;
        tugOfWar(arr, idx + 1, count + 1, totSum, currSum + arr[idx], k, visited, subset1, subset2);
        visited[idx] = false;
        tugOfWar(arr, idx + 1, count, totSum, currSum, k, visited, subset1, subset2);
    }

    public static void tugOfWarInitiate(int[] arr) {
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        int k;
        boolean[] visited = new boolean[arr.length];
        int[] subset1;
        int[] subset2;
        if (arr.length % 2 == 0) {
            k = arr.length / 2;
            subset1 = new int[k];
            subset2 = new int[k];
        }

        else {
            k = (arr.length - 1) / 2;
            subset1 = new int[k];
            subset2 = new int[k + 1];
        }

        tugOfWar(arr, 0, 0, totSum, 0, k, visited, subset1, subset2);

        for (int i = 0; i < subset1.length; i++) {
            System.out.print(subset1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < subset2.length; i++) {
            System.out.print(subset2[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
        tugOfWarInitiate(arr);
        System.out.println(minDiff);
    }
}