class Client {
    public static void main(String[] args) throws Exception {
        linkedlist ll = new linkedlist();
        for (int i = 0; i < 10; i++) {
            ll.addLast(i);
        }
        System.out.println(ll);
    }
}