package Queue;

public class CustomQueue {

    protected int[] data;
    protected static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot remove from a empty queue");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {

            data[i - 1] = data[i];
        }
        end--;

        return removed;
    }

    public int first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot remove from a empty queue");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.println(data[i]);
        }
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }
}
