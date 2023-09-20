package datastructures.linkedlist;

/*
* Another way of writing the LinkedList class.
* In this class we have set the Node class as inner class.*
*/

import java.util.HashSet;
import java.util.Set;

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
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length of list: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    /*
    * Title: removeLast.
    * Description: Removes the last element from the linkedlist.
    *              Handles the edge case where linkedlist length is 0.
    */
    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if(length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
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
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        if(index == 0) {
            return removeFirst();
        }

        if(index == length - 1) {
            return removeLast();
        }

        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;

        for(int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void partitionList(int x) {
        // Return if the list is empty
        if (head == null) return;

        // Create two dummy nodes for the new lists
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Initialize pointers for the new lists
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Start iterating from the head
        Node current = head;

        // Iterate through the linked list
        while (current != null) {
            // Add nodes to the new lists
            // based on their value
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            // Move to the next node
            current = current.next;
        }

        // Mark the end of the second list
        prev2.next = null;

        // Connect the two new lists
        prev1.next = dummy2.next;

        // Update the head of the list
        head = dummy1.next;
    }

    public void removeDuplicates() {
        // Create a set to store unique values
        Set<Integer> values = new HashSet<>();

        // Initialize the previous node as null
        Node previous = null;

        // Start at the head of the linked list
        Node current = head;

        // Iterate through the list until the end
        while (current != null) {
            // Check if the value is a duplicate
            if (values.contains(current.value)) {
                // Remove the current node from the list
                previous.next = current.next;

                // Decrement the list length by 1
                length -= 1;
            } else {
                // Add the unique value to the set
                values.add(current.value);

                // Update previous to the current node
                previous = current;
            }
            // Move to the next node in the list
            current = current.next;
        }
    }
}
