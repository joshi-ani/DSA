package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.printQueueDetails();
        queue.enqueue(8);
        queue.enqueue(9);
        queue.printQueueDetails();
    }
}
