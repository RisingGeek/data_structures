import java.util.LinkedList;

public class iterative_preorder {
    public static class NodeClass {
        Node node = null;
        boolean p = false;
        boolean l = false;
        boolean r = false;

        NodeClass(Node node) {
            this.node = node;
        }
    }

    public static void iterativePreorder(Node node) {
        LinkedList<NodeClass> stack = new LinkedList<>();
        NodeClass r = new NodeClass(node);
        stack.addFirst(r);
        while (stack.size() > 0) {
            NodeClass rnode = stack.getFirst();
            if (rnode.node == null) {
                stack.removeFirst();
            } else if (rnode.p == false) {
                System.out.print(rnode.node.data + " ");
                rnode.p = true;
            } else if (rnode.l == false) {
                NodeClass newNode = new NodeClass(rnode.node.left);
                stack.addFirst(newNode);
                rnode.l = true;
            } else if (rnode.r == false) {
                NodeClass newNode = new NodeClass(rnode.node.right);
                stack.addFirst(newNode);
                rnode.r = true;
            }
            else {
                stack.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        iterativePreorder(root);
    }
}