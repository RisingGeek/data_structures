import java.util.ArrayList;

public class flatten {
    public static void flattenTree(Node node) {
        ArrayList<Node> newChildren = new ArrayList<>();
        for (Node child : node.children) {
            flattenTree(child);
            newChildren.add(child);
            for (Node subChild : child.children) {
                newChildren.add(subChild);
            }
            child.children.clear();
        }
        node.children = newChildren;
    }

    public static void preorder(Node node, ArrayList<Node> traversal) {
        traversal.add(node);
        for (Node child : node.children) {
            preorder(child, traversal);
        }
    }

    public static void flatten2(Node node, ArrayList<Node> traversal) {
        Node root = traversal.get(0);
        root.children.clear();
        for (int i = 1; i < traversal.size(); i++) {
            root.children.add(traversal.get(i));
            traversal.get(i).children.clear();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,
                -1 };
        construct_tree ct = new construct_tree();
        Node root = ct.make_tree(arr);

        // flattenTree(root);

        ArrayList<Node> traversal = new ArrayList<>();
        preorder(root, traversal);
        flatten2(root, traversal);
        ct.display(root);
    }
}