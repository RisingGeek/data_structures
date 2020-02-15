class partition_set {
    // sumArr size - k
    // isTaken - arr.length
    public static boolean partitionSet(int[] arr, int idx, int k, int[] sumArr) {
        if (k == 1)
            return true;
        if (arr.length < k)
            return false;

        if (idx == arr.length) {
            for (int i = 1; i < sumArr.length; i++) {
                if (sumArr[i] != sumArr[i - 1])
                    return false;
            }
            // System.out.println(sumArr[0]);
            return true;
        }

        // for each number, there are k choices
        for (int i = 0; i < sumArr.length; i++) {
            // take
            sumArr[i] += arr[idx];
            boolean ans = partitionSet(arr, idx + 1, k, sumArr);
            // untake
            sumArr[i] -= arr[idx];

            if (ans)
                return ans;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 5, 6 };
        int k = 3;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % k == 0) {
            int[] sumArr = new int[k];
            boolean ans = partitionSet(arr, 0, k, sumArr);
            System.out.println(ans);
        } else {
            System.out.println(false);
        }

    }
}