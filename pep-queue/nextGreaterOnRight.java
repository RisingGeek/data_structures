public class nextGreaterOnRight {
    public static void nextGreater(int[] arr, int[] ans) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    found = true;
                    break;
                }
            }
            if (!found)
                ans[i] = -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 1, 9, 6, 8 };
        int[] ans = new int[arr.length];
        nextGreater(arr, ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}