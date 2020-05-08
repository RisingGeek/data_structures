class reversell {
    public static int size(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private static Node getNodeAt(Node head, int idx) {
        Node temp = head;
        while (idx-- > 0) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reverseIterative(Node head, int size) {
        int i = 0, j = size - 1;
        while (i < j) {
            Node left = getNodeAt(head, i);
            Node right = getNodeAt(head, j);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            i++;
            j--;
        }
    }

    public static Node reverseRecursive(Node node, int idx, int size) {
        if (idx == size / 2) {
            return size % 2 == 0 ? node : node.next;
        }

        Node rec = reverseRecursive(node.next, idx + 1, size);
        int temp = node.data;
        node.data = rec.data;
        rec.data = temp;
        return rec.next;
    }

    public static void reverseIterativeAnother(Node head, int size) {
        int j = size - 1;
        int mid = size / 2;
        while (mid-- > 0) {
            Node left = getNodeAt(head, 0);
            Node right = getNodeAt(head, j);
            head = left.next;
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            j -= 2;
        }
    }

    public static Node reverseIterativeNode(Node head) {
        Node curr = head, prev = null, next = head;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) throws Exception {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        int size = size(head);
        temp = reverseIterativeNode(head);
        // temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}