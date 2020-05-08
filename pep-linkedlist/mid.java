class mid {
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) throws Exception {
        Node head = new Node(1);
        Node temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        System.out.println(getMid(head).data);
    }
}