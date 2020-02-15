class recover_binary_search_tree {
    public static Node x = null;
    public static Node y = null;
    public static Node prev = null;

    public static void recover_bst(Node node) {
        if (node == null)
            return;

        recover_bst(node.left);
        if (prev != null && node.data < prev.data) {
            if (x == null) {
                x = prev;
            }
            y = node;
        }
        prev = node;
        // System.out.println(prev);

        recover_bst(node.right);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, 2, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);

        recover_bst(root);
        
        int temp = x.data;
        x.data = y.data;
        y.data = temp;
        ct.display(root);
    }
}