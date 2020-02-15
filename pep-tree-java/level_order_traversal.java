import java.util.LinkedList;

public class level_order_traversal {

    public static void method1(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);

        int level = 0;
        System.out.print("level" + level + "-> ");
        while (queue.size() != 1) {

            if (queue.getFirst() == null) {
                queue.removeFirst();
                queue.addLast(null);
                level++;
                System.out.println();
                System.out.print("level" + level + "-> ");
                continue;
            }

            Node rn = queue.removeFirst();
            System.out.print(rn.data + " ");
            if (rn.left != null)
                queue.addLast(rn.left);
            if (rn.right != null)
                queue.addLast(rn.right);
        }
    }

    // Two queue
    public static void method2(Node root) {
        LinkedList<Node> queue1 = new LinkedList<>();
        LinkedList<Node> queue2 = new LinkedList<>();
        queue1.addLast(root);

        int level = 0;
        System.out.print("level" + level + "-> ");

        while (queue1.size() != 0 || queue2.size() != 0) {

            if (queue1.size() == 0) {
                LinkedList<Node> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                level++;
                System.out.println();
                System.out.print("level" + level + "-> ");
            }

            Node rn = queue1.removeFirst();
            System.out.print(rn.data + " ");
            if (rn.left != null)
                queue2.addLast(rn.left);
            if (rn.right != null)
                queue2.addLast(rn.right);
        }
    }

    // Two loops
    public static void method3(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;

        while (queue.size() != 0) {

            int size = queue.size();
            System.out.print("level" + level + "-> ");
            for (int i = 0; i < size; i++) {
                Node rn = queue.removeFirst();
                System.out.print(rn.data + " ");
                if (rn.left != null)
                    queue.addLast(rn.left);
                if (rn.right != null)
                    queue.addLast(rn.right);
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        method2(root);
    }
}