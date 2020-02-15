import java.util.HashMap;

public class path_sum3 {
    public static int pathSum_III(Node node, int prefixSum, int target, HashMap<Integer, Integer> map) {

        if (node == null)
            return 0;

        prefixSum += node.data;
        int count = map.getOrDefault(prefixSum - target, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += pathSum_III(node.left, prefixSum, target, map);
        count += pathSum_III(node.right, prefixSum, target, map);

        if (map.get(prefixSum) == 1) {
            map.remove(prefixSum);
        } else {
            map.put(prefixSum, map.get(prefixSum) - 1);
        }
        System.out.println(map);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 3, 3 - 1, -1, -2, -1, -1, 2, -1, 1, -1, -1, -3, -1, 11, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = pathSum_III(root, 0, 8, map);
        System.out.println(ans);
    }
}