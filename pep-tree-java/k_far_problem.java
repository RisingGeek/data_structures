import java.util.ArrayList;

class k_far_problem {

    public static ArrayList<Node> path(Node root, int data) {

        if (root == null) {
            return new ArrayList<Node>();
        }

        if (root.data == data) {
            ArrayList<Node> arr = new ArrayList<>();
            arr.add(root);
            return arr;
        }

        ArrayList<Node> left = path(root.left, data);
        if (left.size() > 0) {
            left.add(root);
            return left;
        }
        ArrayList<Node> right = path(root.right, data);
        if (right.size() > 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<Node>();
    }

    public static void k_away(Node node, int k, Node rnode) {
        if (node == null)
            return;
        if (node == rnode)
            return;
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        k_away(node.left, k - 1, rnode);
        k_away(node.right, k - 1, rnode);
    }

    public static void k_far(Node root, int data, int k) {
        ArrayList<Node> root_to_node_path = path(root, data);
        Node prev_node = null;
        for (int i = 0; i < root_to_node_path.size(); i++) {
            if (k - i < 0)
                break;
            k_away(root_to_node_path.get(i), k - i, prev_node);
            prev_node = root_to_node_path.get(i);
        }
    }

    public static int k_far2(Node root, int data, int k) {
        if (root == null)
            return -1;

        if (root.data == data) {
            k_away(root, k, null);
            return 1;
        }

        int l = k_far2(root.left, data, k);
        if (l != -1 && k - l >= 0) {
            k_away(root, k - l, root.left);
            return l + 1;
        }
        int r = k_far2(root.right, data, k);
        if (r != -1 && k - r >= 0) {
            k_away(root, k - r, root.right);
            return r + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        k_far2(root, 50, 3);
    }
}