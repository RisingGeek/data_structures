public class demo {
    public static void main(String[] args) {
        int[] arr = {10,20,-1,30,70,-1,80,100,-1,110,-1,-1,90,-1,-1,40,120,140,-1,150,-1,-1,-1,-1};
        construct_tree ct = new construct_tree();
        Node root = ct.make_tree(arr);
        ct.display(root);
    }
}