public class vertical_sum {
    static Node head = null;

    public static void verticalSum(Node node, Node prevNode, Node nNode, boolean isLeftChild) {
        if (node == null)
            return;

        Node newNode = nNode;
        // new node
        if (nNode == null) {
            newNode = new Node(node.data);
            if (prevNode != null) {
                if (isLeftChild) {
                    prevNode.left = newNode;
                    newNode.right = prevNode;
                    head = newNode;
                } else {
                    prevNode.right = newNode;
                    newNode.left = prevNode;
                }
            } else {
                head = newNode;
            }
        } else {
            newNode.data += node.data;
        } // add data

        verticalSum(node.left, newNode, newNode.left, true);
        verticalSum(node.right, newNode, newNode.right, false);
    }

    public static void verticalSum2(Node node, Node prevNode, Node nNode, boolean isLeftChild) {
        if (node == null)
            return;

        Node left = node.left;
        Node right = node.right;
        // new node
        if (nNode != node) { // add data
            nNode.data += node.data;
        } else if (prevNode != null) {
            if (isLeftChild) {
                // prevNode.left = node;
                nNode.right = prevNode;
                head = nNode;
            } else {
                // prevNode.right = node;
                nNode.left = prevNode;
            }
        } else {
            head = node;
        }

        verticalSum2(left, node, nNode.left, true);
        verticalSum2(right, node, nNode.right, false);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, 7, -1, -1, 8, 9, -1, -1, -1, 7, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        tree_util ct = new tree_util();
        // int[] arr2 = { 1, -1, 2, -1, 3, 3, -1, -1, -1 };
        Node root = ct.construct_tree(arr);
        // verticalSum(root, null, null, false);
        verticalSum2(root, null, root, false);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
}