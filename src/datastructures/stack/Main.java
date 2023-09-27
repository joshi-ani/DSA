package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(1);

        stack.printStackDetails();

        stack.push(2);

        stack.printStackDetails();

        System.out.println("Stack pop value: " + stack.pop().value);
        stack.printStackDetails();
    }
}
