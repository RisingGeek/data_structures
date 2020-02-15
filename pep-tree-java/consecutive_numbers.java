public class consecutive_numbers {
    static int maxLength = 0;

    public static void consecutiveNumbers(Node root, int length, int value) {
        if (root == null)
            return;

        if (root.data == value) {
            length++;
            maxLength = Math.max(maxLength, length);
        } else {
            length = 1;
        }
        consecutiveNumbers(root.left, length, root.data + 1);
        consecutiveNumbers(root.right, length, root.data + 1);
    }

    public static int consecutiveNumbers2(Node root, int length, int value) {
        if (root == null)
            return 0;

        if (root.data == value) {
            length++;
        } else {
            length = 1;
        }
        int left = consecutiveNumbers2(root.left, length, root.data + 1);
        int right = consecutiveNumbers2(root.right, length, root.data + 1);

        return Math.max(length, Math.max(left, right));
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, 8, -1, -1, 4, 5, -1, -1, 9, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        // consecutiveNumbers(root, 0, root.data);
        // System.out.println(maxLength);

        int ans = consecutiveNumbers2(root, 0, root.data);
        System.out.println(ans);
    }
}