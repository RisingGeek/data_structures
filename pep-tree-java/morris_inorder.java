public class morris_inorder {
    public static Node rightMost(Node curr, Node node) {
        while(node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }

    public static void morrisInorder(Node root) {
        Node curr = root;
        while(curr != null) {
            if(curr.left != null) {
                Node pred = rightMost(curr, curr.left);
                if(pred.right == curr) {
                    //break thread
                    pred.right = null;
                    System.out.print(curr.data+" ");
                    curr = curr.right;
                }
                else {
                    //make thread
                    pred.right = curr;
                    curr = curr.left;
                }
            }
            else {
                //leftmost node
                System.out.print(curr.data+" ");
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 8, -1, -1, 9, 10, -1, -1, 11, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        morrisInorder(root);
    }
}