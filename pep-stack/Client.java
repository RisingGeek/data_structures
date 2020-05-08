class Client {
    public static void main(String[] args) throws Exception {
        DynamicStack stack = new DynamicStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.size());
        stack.push(40);
        stack.push(50);
        System.out.println(stack.size());
        System.out.println(stack.top());
    }
}