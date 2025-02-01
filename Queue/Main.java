package Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        // CustomQueue queue = new DynamicQueue(5);
        CircularQueue queue = new DynamicCircularQueue(5);

        queue.insert(20);
        queue.insert(25);
        queue.insert(40);
        queue.insert(60);
        queue.insert(10);
        queue.insert(87);
        queue.insert(67);

        System.out.println(queue.remove());
        queue.insert(90);

        System.out.println("after remove");
        queue.display();
    }
}
