/**
 * Esther Adedapo
 * NSID: fxy319
 * Student Number: 11366614
 * Instructor: Kemin Wang
 * Lecture Section: L01
 */

import java.util.LinkedList;



public static class Stack<I> implements StackOperations<I> {
    private LinkedList<I> object;  // Corrected the field name to lowercase 'object'

    /**
     * Constructor for Stack
     * Create new ArrayList
     */
    public Stack() {
        object = new LinkedList<>();
    }

    /**
     * Add item to top of the Stack
     * @param item the item to be added
     */
    @Override
    public void push(I item) {
        object.addLast(item);  // Corrected cast and added proper generics
    }

    /**
     * Removes item from the top of the Stack
     */
    @Override
    public void pop() {
        if (!object.isEmpty()) {
            object.removeLast();  // Removes the last element in the stack
        }
    }

    /**
     * Gets item at the top of the Stack
     */
    @Override
    public I peek() {
        if (!object.isEmpty()) {
            return object.getLast();  // Returns the last element in the stack
        }
        return null;  // Return null if stack is empty
    }

    /**
     * Returns size of items in the Stack
     */
    @Override
    public int size() {
        return object.size();
    }

    /**
     * Returns True if Stack is empty and False if not
     */
    @Override
    public boolean isEmpty() {
        return object.isEmpty();  // Simplified return statement
    }
}


public void main() {

     Stack<Integer> s = new Stack<>();

        /* Testing Constructor */
        if (s.object == null) {
            System.out.println("Error: Stack should be initialized empty.");
        }

        /* Testing Push */
        s.push(1);
        if (s.peek() != 1) {
            System.out.println("Error: Stack not pushing items properly.");
        }
        if (s.size() != 1) {
            System.out.println("Error: Stack not updating size after pushing items.");
        }

        s.push(2);
        s.push(3);
        if (s.peek() != 3) {
            System.out.println("Error: Stack not pushing items properly.");
        }
        if (s.size() != 3) {
            System.out.println("Error: Stack size incorrect after multiple pushes.");
        }

        /* Testing Pop */
        s.pop();
        if (s.peek() != 2) {
            System.out.println("Error: Stack not popping items properly.");
        }
        if (s.size() != 2) {
            System.out.println("Error: Stack size incorrect after popping.");
        }

        s.pop();
        s.pop();
        if (!s.isEmpty()) {
            System.out.println("Error: Stack should be empty after popping all items.");
        }

        /* Testing isEmpty */
        if (!s.isEmpty()) {
            System.out.println("Error: Stack isEmpty method not working correctly.");
        }




}
