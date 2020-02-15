class k_away_problem {
    public static void k_away(Node node, int k) {
        if (node == null)
            return;
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        k_away(node.left, k - 1);
        k_away(node.right, k - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        k_away(root.right, 1);
    }
}