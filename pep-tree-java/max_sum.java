public class max_sum {
    public static int[] max_sum_ret(Node root) {
        if (root == null) {
            int ans[] = new int[2];
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }

        int[] left = max_sum_ret(root.left);
        int[] right = max_sum_ret(root.right);

        int ans[] = new int[2];
        ans[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + root.data);
        ans[1] = Math.max(left[1], right[1]) + root.data;

        return ans;
    }

    public static int sum = 0;

    public static int max_sum_ret2(Node root) {
        if (root == null) {
            return 0;
        }

        int left = max_sum_ret2(root.left);
        int right = max_sum_ret2(root.right);

        if (root.left != null && root.right != null) {
            sum = Math.max(sum, left + right + root.data);
        }

        return Math.max(left, right) + root.data;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        int ans = max_sum_ret2(root);
        System.out.println(sum);
    }
}