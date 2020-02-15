import java.util.LinkedList;

public class left_view {
    public static int max_level = -1;

    public static void left_view_tree(Node root, int level) {
        if (root == null)
            return;

        if (level > max_level) {
            System.out.println(root.data);
            max_level = level;
        }

        left_view_tree(root.left, level + 1);
        left_view_tree(root.right, level + 1);
    }

    public static void left_view_level_order(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node rnode = queue.removeFirst();
                if (i == 0 || i == size - 1)
                    System.out.print(rnode.data + " ");

                if (rnode.left != null)
                    queue.addLast(rnode.left);
                if (rnode.right != null)
                    queue.addLast(rnode.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);

        left_view_level_order(root);
    }
}