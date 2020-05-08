import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class diagonalTraversal {

    public static class HNodePair {
        Node node;
        int hd;

        HNodePair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void diagonal_traversal(Node root) {
        // hd : array of elements in hd
        SortedMap<Integer, ArrayList<Integer>> sm = new TreeMap<>();
        LinkedList<HNodePair> queue = new LinkedList<>();

        int hd = 0;
        HNodePair newNode = new HNodePair(root, hd);
        queue.addLast(newNode);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                HNodePair rnode = queue.removeFirst();
                hd = rnode.hd;

                ArrayList<Integer> traversal = sm.getOrDefault(hd, new ArrayList<Integer>());
                traversal.add(rnode.node.data);
                sm.put(hd, traversal);

                if (rnode.node.left != null)
                    queue.addLast(new HNodePair(rnode.node.left, hd + 1));
                if (rnode.node.right != null)
                    queue.addLast(new HNodePair(rnode.node.right, hd));
            }
        }

        System.out.println(sm);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, 8, -1, -1, 7, -1, 9, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        diagonal_traversal(root);
    }
}