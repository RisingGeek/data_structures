class Queue {
    protected int que[];
    protected int front;
    protected int rear;
    protected int size;

    public Queue() {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.resize(size);
    }

    public Queue(int size) {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.resize(size);
    }

    protected void resize(int size) {
        this.que = new int[size];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isFull() {
        return this.size() == que.length;
    }

    private int _top() {
        return this.que[this.front];
    }

    public int top() throws Exception {
        if (this.size() == 0)
            throw new Exception("Queue empty");
        return _top();
    }

    private void _push(int x) {
        this.rear = (this.rear + 1) % que.length;
        if (size == 0)
            this.front = this.rear;
        que[this.rear] = x;
        this.size++;
    }

    public void push(int x) throws Exception {
        if (this.isFull())
            throw new Exception("Queue full");
        _push(x);
    }

    private int _pop() {
        int ret = this.que[this.front];
        this.front = (this.front + 1) % que.length;
        this.size--;
        return ret;
    }

    public int pop() throws Exception {
        if (this.isEmpty())
            throw new Exception("Queue empty");
        return _pop();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (this.size() > 0) {
            sb.append(this._top() + ", ");
            this._pop();
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}