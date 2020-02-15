class Bst_problems {
    public static class Bst {
        boolean isBst = true;
        int count = 0;
        int l_bst_size = 0;
        Node l_bst_root = null;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
    }

    public static Bst bst_sol(Node root) {

        if (root == null)
            return new Bst();

        Bst ans = new Bst();

        Bst left = bst_sol(root.left);
        Bst right = bst_sol(root.right);

        if (left.isBst == true && right.isBst == true && left.max < root.data && right.min > root.data) {
            ans.isBst = true;
            ans.count = left.count + right.count + 1;
            ans.l_bst_size = ans.count;
            ans.l_bst_root = root;
        } else {
            ans.isBst = false;
            ans.count = left.count + right.count;
            ans.l_bst_size = Math.max(left.l_bst_size, right.l_bst_size);
            ans.l_bst_root = (left.l_bst_size > right.l_bst_size) ? left.l_bst_root : right.l_bst_root;
        }
        ans.max = Math.max(Math.max(left.max, right.max), root.data);
        ans.min = Math.min(Math.min(left.min, right.min), root.data);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        Bst obj = bst_sol(root);
        System.out.println(obj.isBst);
        System.out.println(obj.count);
        System.out.println(obj.l_bst_size);
        System.out.println(obj.l_bst_root.data);
        System.out.println(obj.min);
        System.out.println(obj.max);
    }
}