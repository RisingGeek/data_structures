public class bst_from_inorder {
    public static Node bstFromInorder(int[] arr, int s, int e) {
        if (s == e) {
            return new Node(arr[s]);
        }

        if (s > e)
            return null;

        int mid = s + (e - s) / 2;
        Node newNode = new Node(arr[mid]);

        newNode.left = bstFromInorder(arr, s, mid - 1);
        newNode.right = bstFromInorder(arr, mid + 1, e);
        return newNode;
    }

    public static void addNode(Node root, int data, Node par, boolean left) {
        if (root == null) {
            Node newNode = new Node(data);
            if (left) {
                par.left = newNode;
            } else {
                par.right = newNode;
            }
            return;
        }

        if (data < root.data) {
            addNode(root.left, data, root, true);
        } else {
            addNode(root.right, data, root, false);
        }
    }

    public static Node addNode2(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = addNode2(root.left, data);
        } else {
            root.right = addNode2(root.right, data);
        }
        return root;
    }

    public static int findGreatest(Node root) {
        return root.right == null ? root.data : findGreatest(root.right);
    }

    public static Node deleteNode(Node root, int data) {
        if (root.data == data) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null && root.right != null)
                return root.right;
            if (root.right == null && root.left != null)
                return root.left;
            int max = findGreatest(root.left);
            root.left = deleteNode(root.left, max);
            root.data = max;
            return root;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else {
            root.right = deleteNode(root.right, data);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60 };
        Node root = bstFromInorder(arr, 0, arr.length - 1);
        tree_util ct = new tree_util();
        addNode(root, 25, null, false);
        deleteNode(root, 50);
        ct.display(root);
    }
}