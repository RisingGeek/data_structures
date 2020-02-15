
public class preorder_tree {
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

	public static void main(String[] args) {
//		Node root = new Node(10);
		int[] arr= {10,20,30,-1,-1,40,-1,-1,50,60,80,-1,-1,-1,70,90,-1,100,-1,-1,-1};
		Node root=construct_tree(arr);
		display(root);
	}
}