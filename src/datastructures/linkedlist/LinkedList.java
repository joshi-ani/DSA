package datastructures.linkedlist;

/*
* Another way of writing the LinkedList class.
* In this class we have set the Node class as inner class.*
*/

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        private int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println("Value is: " + temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Head: " + tail.value);
    }

    public void getLength() {
        System.out.println("Head: " + length);
    }

}
