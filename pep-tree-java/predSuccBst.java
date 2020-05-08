public class predSuccBst {
    static Node pred = null;
    static Node succ = null;

    public static Node getLeftmost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node getRightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static boolean predSucc(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data) {
            if (root.right != null) {
                succ = getLeftmost(root.right);
            }
            if (root.left != null) {
                pred = getRightMost(root.left);
            }
            return true;
        }
        if (data < root.data) {
            boolean left = predSucc(root.left, data);
            if (left == true) {
                if (succ == null)
                    succ = root;
                return true;
            }
        } else {
            boolean right = predSucc(root.right, data);
            if (right == true) {
                if (pred == null)
                    pred = root;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 50, 40, 20, 10, -1, -1, 30, -1, -1, -1, 60, -1, 70, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        predSucc(root, 70);
        
        System.out.println(succ != null ? succ.data : succ);
        System.out.println(pred != null ? pred.data : pred);
    }
}