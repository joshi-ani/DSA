package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private void printStack() {
        Node temp = top;
        while(temp != null) {
            System.out.println("Value of node: " + temp.value);
            temp = temp.next;
        }
    }

    private void getTop() {
        System.out.println("Value of top: " + top.value);
    }

    private void getHeight() {
        System.out.println("Height of Stack: " + height);
    }

    public void printStackDetails() {
        if(height > 0) {
            printStack();
            getTop();
            getHeight();
        } else {
            System.out.println("Stack is empty");
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(height == 0) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
