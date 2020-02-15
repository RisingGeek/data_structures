public class element_twice {

    public static void elementTwiceUtil(int[] arr, int n, int el) {
        if (el > n) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // for every element there are 2*n choices
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i + el + 1 < arr.length && arr[i + el + 1] == 0) {
                arr[i] = el;
                arr[i + el + 1] = el;

                elementTwiceUtil(arr, n, el + 1);

                arr[i] = 0;
                arr[i + el + 1] = 0;
            }
        }
    }

    public static void elementTwice(int n) {
        int[] arr = new int[2 * n];
        elementTwiceUtil(arr, n, 1);
    }

    public static void main(String[] args) {
        elementTwice(3);
    }
}