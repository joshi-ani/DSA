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
            for(int i = length - 1; i > index; i--) {
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
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void swapFirstLast() {
        // If there are less than two nodes in the list, there's nothing to swap
        if (length < 2) return;

        // Swap the values of the head and tail nodes
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            // swap the prev and next pointers of the current node
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // move to the next node
            current = current.prev;
        }

        // swap the head and tail pointers
        temp = head;
        head = tail;
        tail = temp;
    }

    public boolean isPalindrome() {
        // if the list has only 1 or 0 nodes, it's automatically a palindrome
        if (length <= 1) return true;

        // set up two pointers starting from opposite ends of the list
        Node forwardNode = head;
        Node backwardNode = tail;

        // iterate through the list until the two pointers meet in the middle
        for (int i = 0; i < length / 2; i++) {
            // if the values at the two pointers don't match, the list is not a palindrome
            if (forwardNode.value != backwardNode.value) return false;

            // move the pointers toward the center of the list
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }

        // if the loop completes without returning false, the list is a palindrome
        return true;
    }

    public void swapNodePairs() {
        // Create a placeholder (dummyNode) node to simplify swapping.
        Node dummyNode = new Node(0);

        // Link the dummyNode node to the start of our list.
        dummyNode.next = head;

        // Initialize 'previousNode' to 'dummyNode' to remember the node
        // before each pair we're swapping.
        Node previousNode = dummyNode;

        // Continue as long as there's a pair of nodes to swap.
        while (head != null && head.next != null) {

            // Identify the first node of the pair to swap.
            Node firstNode = head;

            // Identify the second node of the pair to swap.
            Node secondNode = head.next;

            // Connect the previousNode's 'next' pointer to secondNode,
            // essentially skipping over firstNode.
            previousNode.next = secondNode;

            // Connect firstNode to the node after secondNode.
            // This ensures we don't lose the rest of the list.
            firstNode.next = secondNode.next;

            // Connect secondNode back to firstNode,
            // completing the swap.
            secondNode.next = firstNode;

            // Adjust 'prev' pointers for our doubly linked list.
            // Set secondNode's 'prev' to the node before current pair.
            secondNode.prev = previousNode;

            // Set firstNode's 'prev' to secondNode as they've been swapped.
            firstNode.prev = secondNode;

            // If there's a node after our current pair, set its 'prev' to firstNode.
            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            // Move the head pointer to the node after the current pair.
            head = firstNode.next;

            // Update 'previousNode' for the next pair of nodes.
            previousNode = firstNode;
        }

        // After swapping all pairs, update our list's head to
        // start at the node after dummyNode.
        head = dummyNode.next;

        // Ensure the new head's 'prev' is null, indicating the start of list.
        if (head != null) head.prev = null;
    }

}
