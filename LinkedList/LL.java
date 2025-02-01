package LinkedList;

public class LL {
    private Node head;
    private Node tail;

    private int size;

    LL() {
        this.size = 0;
    }

    public class Node {

        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void insertFirst(int val) {

        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("End");
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public void deleteFirst() {
        int val = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void deleteLast() {
        Node secondeLast = get(size - 2);

        tail = secondeLast;
        tail.next = null;
        size--;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }

        Node dnodeprev = get(index - 1);
        dnodeprev.next = dnodeprev.next.next;
    }

    public Node find(int value) {

        Node temp = head;
        while (temp != null) {
            if (temp.val == value) {
                return temp;
            }
            temp = temp.next;
        }

        return temp;

    }

    public Node get(int index) {
        Node nxt = head;
        for (int i = 1; i < index; i++) {
            nxt = nxt.next;
        }
        return nxt;
    }

}
