public class Client {
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(5);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue);
        // System.out.println(queue.top());
        // queue.pop();
        // System.out.println(queue.top());
    }
}