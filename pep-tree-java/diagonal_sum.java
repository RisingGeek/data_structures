public class diagonal_sum {
    // public static void diagonalSum(Node node, Node prevNode, Node nNode, boolean isLeft) {
    //     if (node == null)
    //         return;

    //         if(prevNode != null) {
    //             System.out.println(node.data+" "+prevNode.data+" "+nNode.data);
    //         }
    //     Node right = node.right;
    //     if (nNode != node) {
    //         nNode.data += node.data;
    //     } else if (isLeft) {
    //         nNode.right = prevNode;
    //     }

    //     diagonalSum(node.left, node, nNode.left, true);
    //     diagonalSum(right, prevNode, nNode, false);
    // }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, 9, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        // diagonalSum(root, null, root, true);

        // while (root != null) {
        //     System.out.print(root.data + " ");
        //     root = root.left;
        // }
    }
}