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

        System.out.println("After swapping first node with the last node in the doubly linked list:");
        myLinkedList.swapFirstLast();
        myLinkedList.printListDetails();

        System.out.println("After reversing the doubly linked list:");
        myLinkedList.reverse();
        myLinkedList.printListDetails();

        System.out.println("After swapping node pairs in the doubly linked list:");
        myLinkedList.swapNodePairs();
        myLinkedList.printListDetails();

        DoublyLinkedList newDLinkedList = new DoublyLinkedList(1);
        newDLinkedList.append(2);
        newDLinkedList.append(3);
        newDLinkedList.append(2);
        newDLinkedList.append(1);
        newDLinkedList.printListDetails();
        System.out.println("Is the list a Palindrome: " + newDLinkedList.isPalindrome());

    }
}
