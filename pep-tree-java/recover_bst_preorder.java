public class recover_bst_preorder {
    public static int index = 0;

    public static Node recover(int arr[], int lb, int el, int rb) {
        if (index == arr.length)
            return null;

        if (el < lb || el > rb)
            return null;

        Node newNode = new Node(el);
        index++;

        Node left_bst = null, right_bst = null;
        if (index < arr.length) {
            left_bst = recover(arr, lb, arr[index], el);
        }

        if (index < arr.length) {
            right_bst = recover(arr, el, arr[index], rb);
        }

        newNode.left = left_bst;
        newNode.right = right_bst;

        return newNode;
    }

    public static int height(int arr[], int lb, int el, int rb) {
        if (index == arr.length)
            return 0;

        if (el < lb || el > rb)
            return 0;

        index++;

        int lh = 0, rh = 0;
        if (index < arr.length) {
            lh = height(arr, lb, arr[index], el);
        }

        if (index < arr.length) {
            rh = height(arr, el, arr[index], rb);
        }

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 40, 20, 10, 30, 60, 50, 90, 70, 80 };
        tree_util ct = new tree_util();
        // Node root = ct.construct_tree(arr);

        int ans = height(arr, Integer.MIN_VALUE, arr[0], Integer.MAX_VALUE);

        System.out.println(ans);
        // ct.display(ans);
    }
}