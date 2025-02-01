package LinkedList;

public class Main {

    public static void main(String[] args) {
        LL linkedlist = new LL();
        linkedlist.insertLast(50);
        linkedlist.insertFirst(10);
        linkedlist.insertFirst(20);
        linkedlist.insertFirst(30);
        linkedlist.insertFirst(40);
        linkedlist.insertLast(90);
        linkedlist.insert(100, 3);
        linkedlist.deleteFirst();
        linkedlist.deleteLast();
        System.out.println(linkedlist.find(50));

        linkedlist.display();

    }
}
