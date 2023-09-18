package datastructures.linkedlist;

public class Linked_List {
    private Node head;
    private Node tail;
    private int length;

    public Linked_List(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
}
