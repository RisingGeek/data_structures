import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class vertical_traversal {

    public static class HNodePair {
        Node node;
        int dist;

        HNodePair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int minHd = Integer.MAX_VALUE;
    static int maxHd = Integer.MIN_VALUE;

    public static void minMax(Node root, int hd) {
        if (root == null)
            return;

        if (hd < minHd)
            minHd = hd;
        if (hd > maxHd)
            maxHd = hd;

        minMax(root.left, hd - 1);
        minMax(root.right, hd + 1);
    }

    public static void verticalTraversal(Node root) {
        // minMax(root, 0);
        SortedMap<Integer, ArrayList<Integer>> sm = new TreeMap<>();
        LinkedList<HNodePair> queue = new LinkedList<>();

        int hd = 0;
        HNodePair newNode = new HNodePair(root, hd);
        queue.addLast(newNode);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                HNodePair rnode = queue.removeFirst();
                hd = rnode.dist;

                ArrayList<Integer> traversal = sm.getOrDefault(hd, new ArrayList<Integer>());
                traversal.add(rnode.node.data);
                sm.put(hd, traversal);

                if (rnode.node.left != null)
                    queue.addLast(new HNodePair(rnode.node.left, hd - 1));
                if (rnode.node.right != null)
                    queue.addLast(new HNodePair(rnode.node.right, hd + 1));
            }
        }

        System.out.println(sm);
    }

    public static void verticalTraversal2(Node root) {
        minMax(root, 0);
        int hd = 0;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < maxHd - minHd + 1; i++) {
            arr.add(new ArrayList<>());
        }

        LinkedList<HNodePair> queue = new LinkedList<>();
        HNodePair newNode = new HNodePair(root, 0);
        queue.addLast(newNode);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                HNodePair rnode = queue.removeFirst();
                hd = rnode.dist;

                ArrayList<Integer> traversal = arr.get(rnode.dist - minHd);
                traversal.add(rnode.node.data);
                arr.set(rnode.dist - minHd, traversal);

                if (rnode.node.left != null)
                    queue.addLast(new HNodePair(rnode.node.left, hd - 1));
                if (rnode.node.right != null)
                    queue.addLast(new HNodePair(rnode.node.right, hd + 1));
            }
        }

        for (ArrayList<Integer> el : arr) {
            System.out.println(el);
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, 8, -1, -1, 7, -1, 9, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        // verticalTraversal(root);
        verticalTraversal2(root);
    }
}