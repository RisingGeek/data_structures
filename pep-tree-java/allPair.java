class allPair {
    public static class all_pair {
        int height = 0;
        int size = 0;
        boolean find = false;

        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;

        Node pred = null;
        Node succ = null;
        Node prev = null;
    }

    public static void all_sol(Node node, int level, int data, all_pair sol) {
        if (node == null)
            return;

        sol.height = Math.max(sol.height, level + 1);
        sol.size++;
        sol.find = sol.find || node.data == data;

        if (node.data > data && node.data < sol.ceil) {
            sol.ceil = node.data;
        }

        if (node.data < data && node.data > sol.floor) {
            sol.floor = node.data;
        }

        if (node.data == data && sol.pred == null) {
            sol.pred = sol.prev;
        }

        if (sol.prev != null && sol.succ == null && sol.prev.data == data) {
            sol.succ = node;
        }
        sol.prev = node;

        all_sol(node.left, level + 1, data, sol);
        all_sol(node.right, level + 1, data, sol);

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        tree_util ct = new tree_util();
        Node root = ct.construct_tree(arr);
        all_pair sol = new all_pair();
        all_sol(root, 0, 20, sol);

        System.out.println("height" + sol.height);
        System.out.println("size" + sol.size);
        System.out.println("find" + sol.find);
        System.out.println("ceil" + sol.ceil);
        System.out.println("floor" + sol.floor);
        System.out.println("pred" + sol.pred.data);
        System.out.println("succ" + sol.succ.data);
    }
}