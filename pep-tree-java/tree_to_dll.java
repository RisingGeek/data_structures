public class tree_to_dll {

    public static Node head = null;
    public static Node prev = null;

    public static void convert_tree_to_dll(Node root) {

        if (root == null)
            return;

        convert_tree_to_dll(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;

        convert_tree_to_dll(root.right);
    }

    public static Node[] convert_tree_to_dll2(Node root) {
        Node[] ans = new Node[2];
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans[0] = ans[1] = root;
            return ans;
        }

        Node[] left = convert_tree_to_dll2(root.left);
        Node[] right = convert_tree_to_dll2(root.right);

        if (left[1] == null) {
            right[0].left = root;
            root.right = right[0];
            ans[0] = root;
            ans[1] = right[1];
            return ans;
        }
        if (right[0] == null) {
            left[1].right = root;
            root.left = left[1];
            ans[0] = left[0];
            ans[1] = root;
            return ans;
        }

        left[1].right = root;
        root.left = left[1];

        right[0].left = root;
        root.right = right[0];

        ans[0] = left[0];
        ans[1] = right[1];
        return ans;
    }

    public static void convert_tree_to_dll_preorder(Node root) {

        if (root == null)
            return;

        Node l = root.left;
        Node r = root.right;
        if (prev == null) {
            head = root;
            prev = root;
            root.left = null;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convert_tree_to_dll_preorder(l);
        convert_tree_to_dll_preorder(r);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);

        convert_tree_to_dll_preorder(root);
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.right;
        }
        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " -> ");
            prev = prev.left;
        }

        // Node[] ans = convert_tree_to_dll2(root);
        // while (ans[0] != null) {
        // System.out.print(ans[0].data + " -> ");
        // ans[0] = ans[0].right;
        // }
        // System.out.println();
        // while (ans[1] != null) {
        // System.out.print(ans[1].data + " -> ");
        // ans[1] = ans[1].left;
        // }

    }
}