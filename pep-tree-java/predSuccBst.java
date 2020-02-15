public class predSuccBst {
    static Node prev = null;
    static Node pred = null;
    static Node succ = null;

    public static void predSucc(Node root, int data) {
        if (root == null)
            return;

        predSucc(root.left, data);
        if (root.data == data && pred == null) {
            pred = prev;
        }
        if (prev != null && succ == null && prev.data == data) {
            succ = root;
        }
        prev = root;
        predSucc(root.right, data);
    }
}