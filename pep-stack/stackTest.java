import java.util.Stack;

class stackTest {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(1);
        st1.push(2);
        st1.push(3);

        st2.push(1);
        st2.push(5);
        st2.push(3);
        System.out.println(st1.peek() + " " + st2.peek());
        System.out.println(st1.peek() == st2.peek());
        if (st1.peek() == st2.peek()) {
            System.out.println("ok");
        }
    }
}