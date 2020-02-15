public class linearize {
    public static Node linear(Node root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        Node left_tail = linear(root.left);
        Node right_tail = linear(root.right);

        if (left_tail == null) {
            root.left = root.right;
            root.right = null;
        } else if (right_tail == null) {
            root.right = null;
            return left_tail;
        } else {
            left_tail.left = root.right;
            root.right = null;
        }

        return right_tail;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        Node right_tail = linear(root);
        System.out.println("right tail" + right_tail.data);
        ct.display(root);
    }
}