package datastructures.queue;

public class Queue {

    private Node first;

    private Node last;

    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    private void printQueue() {
        Node temp = first;
        while(temp != null) {
            System.out.println("Value of node: " + temp.value);
            temp = temp.next;
        }
    }

    private void printFirst() {
        System.out.println("Value of first node: " + first.value);
    }

    private void printLast() {
        System.out.println("Value of last node: " + last.value);
    }

    private void printLength() {
        System.out.println("Length of queue: " + length);
    }

    public void printQueueDetails() {
        if(length > 0) {
            printQueue();
            printFirst();
            printLast();
            printLength();
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }
}
