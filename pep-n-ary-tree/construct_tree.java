import java.util.LinkedList;

public class construct_tree {

    int index = 0;

    public Node make_tree(int[] arr) {
        LinkedList<Node> stack = new LinkedList<>();
        Node root = new Node(arr[0]);
        stack.addFirst(root);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == -1) {
                Node child = stack.removeFirst();
                Node parent = stack.getFirst();
                parent.children.add(child);
            } else {
                stack.addFirst(new Node(arr[i]));
            }
        }
        return root;
    }

    public void display(Node root) {
        System.out.print(root.data + "-> ");
        for (Node child : root.children) {
            System.out.print(child.data + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            display(child);
        }
    }
}