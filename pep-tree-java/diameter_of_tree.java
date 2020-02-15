
public class diameter_of_tree {
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

	public static int height(Node root) {
		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public static int diameter(Node root) {
		if (root == null)
			return 0;

		int dl = diameter(root.left);
		int dr = diameter(root.right);

		int hl = height(root.left);
		int hr = height(root.right);
		return Math.max(hl + hr + 1, Math.max(dl, dr));
	}

	public static int[] diameter2(Node root) {
		if (root == null) {
			int[] arr = new int[2];
			arr[0] = 0;
			arr[1] = 0;
			return arr;
		}

		int[] left = diameter2(root.left);
		int[] right = diameter2(root.right);

		int[] ans = new int[2];
		ans[0] = Math.max(left[1] + right[1] + 1, Math.max(left[0], right[0]));
		ans[1] = Math.max(left[1], right[1]) + 1;
		return ans;
	}

	public static void main(String[] args) {
//		Node root = new Node(10);
		int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
		Node root = construct_tree(arr);
//		display(root);
		int[] ans = diameter2(root);
		System.out.println(ans[0]);
	}
}