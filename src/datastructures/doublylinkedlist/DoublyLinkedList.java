package datastructures.doublylinkedlist;

import datastructures.linkedlist.LinkedList;

public class DoublyLinkedList {
    private Node head;

    private Node tail;

    private int length;

    class Node {
        int value;
        DoublyLinkedList.Node next;

        DoublyLinkedList.Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    private void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println("Value: " + temp.value);
            temp = temp.next;
        }
    }

    private void printHead() {
        System.out.println("Head: " + head.value);
    }

    private void printTail() {
        System.out.println("Tail: " + tail.value);
    }

    private void printLength() {
        System.out.println("Length of doublyLinkedList: " + length);
    }

    public void printListDetails() {
        if(length != 0) {
            printList();
            printHead();
            printTail();
            printLength();
        } else {
            System.out.println("The list is empty");
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            head.prev = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if(length == 0) { return null; }
        Node temp = tail;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) {
            return null;
        }
        Node temp = head;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp;
        if(index < length/2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for(int i = length; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > length) {
            return false;
        }
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node current = get(index);
        Node before = current.prev;
        before.next = newNode;
        newNode.next = current;
        newNode.prev = before;
        current.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }
        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;
        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }
}
