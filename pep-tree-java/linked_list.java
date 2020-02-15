import java.util.LinkedList;

public class linked_list {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(2);
        ll.addFirst(3);
        int a = ll.removeFirst();
        System.out.println(a);
        System.out.println(ll.getLast());
    }
}