import java.util.ArrayList;
import java.util.Scanner;

public class create_tree {
    static Scanner scan = new Scanner(System.in);
    static int size;

    static class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    public static Node create_n_tree(Node parent, int i) {
        if (parent == null) {
            System.out.println("Enter root of tree: ");
        } else {
            System.out.println("Enter " + i + "th child of " + parent.data + " ");
        }

        int data = scan.nextInt();
        Node child = new Node(data);
        size++;

        System.out.println("Enter number of children of" + child.data);
        int size = scan.nextInt();

        for (int j = 0; j < size; j++) {
            Node gc = create_n_tree(child, j);
            child.children.add(gc);
        }

        return child;
    }

    public static void display(Node root) {
        System.out.print(root.data + ": ");

        for (Node el : root.children) {
            System.out.print(el.data + " ");
        }
        System.out.println();

        for (Node el : root.children) {
            display(el);
        }
    }

    public static void main(String[] args) {
        Node root = create_n_tree(null, 0);
        display(root);
    }
}