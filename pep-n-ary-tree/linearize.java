public class linearize {
    public static void linearizeTree(Node node) {
        for (Node child : node.children) {
            linearizeTree(child);
        }

        while (node.children.size() > 1) {
            Node sl = node.children.get(node.children.size() - 2);
            Node l = node.children.get(node.children.size() - 1);
            Node tail = getTail(sl);
            tail.children.add(l);
            node.children.remove(node.children.size() - 1);
        }
    }

    public static Node getTail(Node node) {
        while (node.children.size() > 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static Node linearizeTree2(Node node) {
        if (node.children.size() == 0)
            return node;
        Node lTail = linearizeTree2(node.children.get(node.children.size() - 1));
        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node slTail = linearizeTree2(node.children.get(i));
            slTail.children.add(node.children.get(i + 1));
            node.children.remove(i + 1);
        }
        return lTail;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,
                -1 };
        construct_tree ct = new construct_tree();
        Node root = ct.make_tree(arr);

        linearizeTree2(root);
        ct.display(root);
    }
}