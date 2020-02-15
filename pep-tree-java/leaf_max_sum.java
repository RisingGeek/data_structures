class leaf_max_sum {

    public static int[] max_sum(Node root) {

        if (root == null)
            return new int[2];

        int left[] = max_sum(root.left);
        int right[] = max_sum(root.right);

        int ans[] = new int[2];
        ans[0] = Math.max(left[0], Math.max(right[0], left[1] + right[1] + root.data));
        ans[1] = Math.max(left[1], right[1]) + root.data;

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        int ans[] = max_sum(root);
        System.out.println(ans[0]);
    }
}