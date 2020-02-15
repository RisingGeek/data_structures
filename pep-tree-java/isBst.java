class isBst {

    public static int prev = Integer.MIN_VALUE;

    public static boolean is_bst(Node node) {
        if (node == null)
            return true;

        boolean is_left_bst = is_bst(node.left);
        if (is_left_bst == false)
            return false;

        if (node.data < prev)
            return false;
        prev = node.data;

        boolean is_right_bst = is_bst(node.right);
        if (is_right_bst == false)
            return false;

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 80, 70, -1, -1, 90, -1, -1, 140, 130, 120, -1, -1, -1, 150, -1, 160, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        System.out.println(is_bst(root));
    }
}