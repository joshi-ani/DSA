package datastructures.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList(1);

        // Append a new node to the linked list based on value
        myLinkedList.append(2);
        myLinkedList.append(3);

        // Prints details of list such as the list values, head, tail and length
        myLinkedList.printListDetails();

        System.out.println("Removed node is: " + myLinkedList.removeLast());
        myLinkedList.printListDetails();
        myLinkedList.removeLast();
        myLinkedList.printListDetails();

        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.printListDetails();

        myLinkedList.prepend(0);
        myLinkedList.printListDetails();

        System.out.println("Removed first node: " + myLinkedList.removeFirst().value);
        myLinkedList.printListDetails();

        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.printListDetails();
        DoublyLinkedList.Node node = myLinkedList.get(0);
        System.out.println("Get node value at index 4: " + (node != null ? node.value : "null"));

        myLinkedList.set(1, 10);
        myLinkedList.printListDetails();
        myLinkedList.insert(1, 2);
        myLinkedList.printListDetails();

        System.out.println("Removed node value: " + myLinkedList.remove(2).value);
        myLinkedList.printListDetails();

    }
}
