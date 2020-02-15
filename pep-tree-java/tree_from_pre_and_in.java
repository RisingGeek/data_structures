public class tree_from_pre_and_in {
    static Node construct_tree(int[] pre, int[] in, int psi, int pei, int isi, int iei) {
        if(psi > pei || isi > iei) return null;

        Node newNode = new Node(pre[psi]);

        // if (isi == iei)
        //     return newNode;

        int foundIndex = -1;
        for (int i = isi; i <= iei; i++) {
            if (in[i] == pre[psi]) {
                foundIndex = i;
                break;
            }
        }

        newNode.left = construct_tree(pre, in, psi + 1, psi + foundIndex - isi, isi, foundIndex - 1);
        newNode.right = construct_tree(pre, in, psi + foundIndex - isi + 1, pei, foundIndex + 1, iei);

        return newNode;
    }

    public static void main(String[] args) {
        int[] pre = { 50, 25, 12, 20, 37, 30, 75, 62, 87 };
        int[] in = { 12, 20, 25, 30, 37, 50, 62, 75, 87 };
        Node root = construct_tree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        tree_util ct = new tree_util();
        ct.display(root);
    }
}