class Stack {
    private int[] st;
    private int top;
    private int size;

    public Stack() {
        resize(10);
        this.top = -1;
        this.size = 0;
    }

    public Stack(int cap) {
        resize(cap);
        this.top = -1;
        this.size = 0;
    }

    protected void resize(int size) {
        this.st = new int[size];
    }

    private void _push(int data) {
        this.st[++this.top] = data;
        this.size++;
    }

    public void push(int data) throws Exception {
        if (this.isFull())
            throw new Exception("StackFull");
        _push(data);
    }

    private int _pop() {
        int val = this.st[this.top];
        this.st[this.top] = 0;
        this.top--;
        this.size--;
        return val;
    }

    public int pop() throws Exception {
        if (this.isEmpty())
            throw new Exception("StackEmpty");
        return _pop();
    }

    public int top() throws Exception {
        if (this.isEmpty())
            throw new Exception("StackEmpty");
        return this.st[this.top];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == st.length;
    }
}