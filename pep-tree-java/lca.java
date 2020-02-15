import java.util.ArrayList;

public class lca {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static int index = 0;

	public static Node construct_tree(int[] arr) {
		if (index == arr.length || arr[index] == -1) {
			index++;
			return null;
		}

		Node node = new Node(arr[index]);
		index++;

		Node left = construct_tree(arr);
		Node right = construct_tree(arr);

		node.left = left;
		node.right = right;
		return node;
	}

	public static void display(Node root) {

		if (root == null)
			return;

		System.out.println(root.data);

		display(root.left);
		display(root.right);
	}

	public static ArrayList<Integer> path(Node root, int data) {

		if (root == null) {
			return new ArrayList<Integer>();
		}

		if (root.data == data) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(root.data);
			return arr;
		}

		ArrayList<Integer> left = path(root.left, data);
		if (left.size() > 0) {
			left.add(root.data);
			return left;
		}
		ArrayList<Integer> right = path(root.right, data);
		if (right.size() > 0) {
			right.add(root.data);
			return right;
		}

		return new ArrayList<Integer>();
	}

	public static int lca_node(ArrayList<Integer> path1, ArrayList<Integer> path2) {
		int prev = -1;
		for (int i = path1.size() - 1, j = path2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (path1.get(i) != path2.get(j))
				break;
			prev = path1.get(i);
		}
		return prev;
	}

	public static Node lca = null;

	public static boolean lca_node2(Node root, int data1, int data2) {

		if (root == null)
			return false;

		boolean selfFound = data1 == root.data || data2 == root.data;
		boolean left = lca_node2(root.left, data1, data2);
		if (lca != null)
			return true;

		boolean right = lca_node2(root.right, data1, data2);
		if (lca != null)
			return true;

		if (left && right || (left && selfFound) || (right && selfFound)) {
			lca = root;
			return true;
		}

		return left || right || selfFound;
	}

	public static void main(String[] args) {
		// Node root = new Node(10);
		int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
		Node root = construct_tree(arr);
		// display(root);
		ArrayList<Integer> path1 = path(root, 20);
		ArrayList<Integer> path2 = path(root, 70);

		// int ancestor = lca_node(path1, path2);
		// System.out.println(ancestor);
		boolean ans = lca_node2(root, 60, 90);
		System.out.println(ans);
		System.out.println(lca.data);
	}
}