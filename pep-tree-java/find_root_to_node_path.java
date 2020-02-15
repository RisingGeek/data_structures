import java.util.ArrayList;

public class find_root_to_node_path {
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

	public static void main(String[] args) {
//		Node root = new Node(10);
		int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
		Node root = construct_tree(arr);
//		display(root);
		ArrayList<Integer> ans = path(root, 60);
		System.out.println(ans);
	}
}