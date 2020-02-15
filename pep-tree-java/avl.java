public class avl {
    public static class AvlNode {
        int data;
        AvlNode left;
        AvlNode right;
        int height;
        int balance;

        AvlNode(int data) {
            this.data = data;
            left = null;
            right = null;
            height = -1;
            balance = 0;
        }
    }

    public static AvlNode ll(AvlNode x) {
        AvlNode y = x.left;
        AvlNode yRight = y.right;

        y.right=x;
        x.left=yRight;
        
        return y;
    }

    public static void main(String[] args) {
    }
}
