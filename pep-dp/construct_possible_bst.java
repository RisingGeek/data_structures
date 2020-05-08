import java.util.ArrayList;
import java.util.Arrays;

class construct_possible_bst {
    public static class Node {
        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Node> possible_bst(int start, int end, ArrayList<Node>[][] dp) {
        System.out.println(start + " " + end);
        ArrayList<Node> al = new ArrayList<>();
        if (start > end) {
            al.add(null);
            return al;
        }

        if (dp[start][end].size() > 0)
            return dp[start][end];

        for (int cut = start; cut <= end; cut++) {
            ArrayList<Node> leftSubtree = possible_bst(start, cut - 1, dp);
            ArrayList<Node> rightSubtree = possible_bst(cut + 1, end, dp);
            for (Node left : leftSubtree) {
                for (Node right : rightSubtree) {
                    Node root = new Node(cut);
                    root.left = left;
                    root.right = right;
                    al.add(root);
                }
            }
        }
        return dp[start][end] = al;
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Node>[][] dp = new ArrayList[n + 1][n + 1];
        for (ArrayList[] row : dp)
            Arrays.fill(row, new ArrayList<>());
        ArrayList<Node> al = possible_bst(1, n, dp);
        System.out.println(al.size());
    }
}