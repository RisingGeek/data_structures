public class tree_util {
    static int index = 0;

    public Node construct_tree(int[] arr) {
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
    
    public void display(Node root) {

		if (root == null)
			return;

		System.out.println(root.data);

		display(root.left);
		display(root.right);
	}
}