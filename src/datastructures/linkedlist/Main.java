package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        // Linked_List myAnotherLinkedList = new Linked_List(4);

        // Append a new node to the linked list based on value
        myLinkedList.append(2);
        myLinkedList.append(3);

        // Prepend a new node into the linked list based on value
        myLinkedList.prepend(0);

        // Remove first node from linked list
        System.out.println(myLinkedList.removeFirst());

        // Retrieve the node from linked list based on the index position
        System.out.println(myLinkedList.get(2));

        // Replace value of a node based on index position and new value
        System.out.println(myLinkedList.set(3, 4));

        // Insert a node into linked list based on index position and value
        myLinkedList.insert(3, 4);

        // Remove node from linked list based on index position
        // myLinkedList.remove(2);

        // Reverse the linked list
        myLinkedList.reverse();

        // Prints the linked list
        myLinkedList.printList();

        System.out.println(myLinkedList.findMiddleNode());

        // (2) Items - Returns 2 Node
        // System.out.println(myLinkedList.removeLast());

        // (1) Items - Returns 1 Node
        // System.out.println(myLinkedList.removeLast());

        // (0) Items - Returns null
        // System.out.println(myLinkedList.removeLast());

    }
}