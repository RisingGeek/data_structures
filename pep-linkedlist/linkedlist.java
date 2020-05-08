import java.util.NoSuchElementException;

public class linkedlist {
    private Node head = null, tail = null;
    private int size = 0;

    private class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = this.head;
        while (temp != null) {
            sb.append(temp.data + ", ");
            temp = temp.next;
        }
        if (this.head != null) {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return this.size;
    }
    /////////////// get functions /////////////

    public int getFirst() {
        if (this.size() == 0)
            throw new NoSuchElementException();
        return head.data;
    }

    public int getLast() {
        if (this.size() == 0)
            throw new NoSuchElementException();
        return tail.data;
    }

    public int getAt(int idx) {
        if (this.size() == 0 || idx < 0 || idx >= this.size())
            throw new NoSuchElementException();
        return getNodeAt(idx).data;
    }

    private Node getNodeAt(int idx) {
        if (this.size == 0 || idx < 0 || idx >= this.size())
            return null;
        Node temp = head;
        while (idx-- > 0) {
            temp = temp.next;
        }
        return temp;
    }

    /////////////// add functions /////////////

    private void addFirstNode(Node node) {
        if (this.size() == 0)
            this.tail = node;
        node.next = this.head;
        this.head = node;
        size++;
    }

    public void addFirst(int data) {
        addFirstNode(new Node(data));
    }

    private void addLastNode(Node node) {
        if (this.size() == 0) {
            this.head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void addLast(int data) {
        addLastNode(new Node(data));
    }

    private void addAtIndexNode(Node node, int idx) {
        if (idx == 0) {
            this.addFirstNode(node);
        } else if (idx == this.size()) {
            this.addLastNode(node);
        } else {
            Node prev = getNodeAt(idx - 1);

            Node temp = prev.next;
            prev.next = node;
            node.next = temp;
        }
        size++;
    }

    public void addAtIndex(int data, int idx) {
        if (idx < 0 || idx > this.size())
            throw new ArrayIndexOutOfBoundsException();
        addAtIndexNode(new Node(data), idx);
    }

    /////////////// remove functions /////////////

    private Node removeFirstNode() {
        if (size() == 1)
            this.tail = null;

        Node rn = head;
        this.head = this.head.next;
        rn.next = null;
        this.size--;
        return rn;
    }

    public Node removeFirst() {
        if (size() == 0)
            throw new NullPointerException();
        return removeFirstNode();
    }

    private Node removeLastNode() {
        Node ret = head;
        if (size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            ret = getNodeAt(this.size() - 2);
            ret.next = null;
            this.tail = ret;
        }
        this.size--;
        return ret;
    }

    public Node removeLast() {
        if (size() == 0)
            throw new NullPointerException();
        return removeLastNode();
    }

    private void removeAtIndexNode(int idx) {
        Node prev = getNodeAt(idx - 1);
        prev.next = prev.next.next;
    }

    public void removeAtIndex(int idx) {
        if (size() == 0 || idx < 0 || idx >= this.size())
            throw new NullPointerException();
        removeAtIndexNode(idx);
    }
}