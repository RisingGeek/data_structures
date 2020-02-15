public class morris_preorder {
    public static Node rightMost(Node curr, Node node) {
        while (node.right != null) {
            if(node.right == curr) return node;
            node = node.right;
        }
        return node;
    }

    public static void morrisPreorder(Node root) {
        Node curr = root;

        while (curr != null) {
            Node nextLeft = curr.left;
            if (nextLeft == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
                continue;
            }

            Node right = rightMost(curr, nextLeft);
            if (right.right == curr) {
                right.right = null;
                curr = curr.right;
                continue;
            }
            else {
                System.out.print(curr.data + " ");
                right.right = curr;
            }
            curr = curr.left;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, -1, -1, 9, 10, -1, -1, 11, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        morrisPreorder(root);
    }
}