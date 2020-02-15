public class range_in_bst {
    public static void rangeBst(Node node, int l, int r) {
        // System.out.println(node.data);
        if (node == null)
            return;
        // if (node.data < l || node.data > r)
        // return;

        if (node.data > l)
            rangeBst(node.left, l, r);
        if (node.data >= l && node.data <= r)
            System.out.println(node.data);
        if (node.data >= l && node.data < r)
            rangeBst(node.right, l, r);
    }

    public static void rangeBst2(Node node, int l, int r) {
        if (node == null)
            return;
        if (node.data < l) {
            rangeBst2(node.right, l, r);
        } else if (node.data > r) {
            rangeBst2(node.left, l, r);
        } else {
            System.out.println(node.data);
            rangeBst2(node.left, l, r);
            rangeBst2(node.right, l, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 80, 40, 20, 10, -1, -1, 30, -1, -1, 60, 50, -1, -1, 70, -1, -1, 120, -1, 160, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        rangeBst2(root, 15, 60);
    }

}