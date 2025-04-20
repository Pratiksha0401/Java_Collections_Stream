package org.example.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Demonstrates Stack operations using:
 * 1. java.util.Stack
 * 2. java.util.LinkedList
 * 3. java.util.ArrayList
 */
public class Demo {
    public static void main(String[] args) {
        // === STACK USING java.util.Stack ===

        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements to the top of the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Stack after pushes: " + stack); // [1, 2, 3, 4, 5]

        // Pop (remove and return) the top element
        Integer removedElement = stack.pop();
        System.out.println("Stack after pop: " + stack); // [1, 2, 3, 4]

        // Peek (look at top element without removing it)
        Integer peek = stack.peek();
        System.out.println("Top element (peek): " + peek); // 4
        System.out.println("Stack after peek (unchanged): " + stack); // [1, 2, 3, 4]

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Get current size of stack
        System.out.println("Stack size: " + stack.size()); // 4

        // Search for an element (returns 1-based position from top)
        int search = stack.search(3);
        System.out.println("Position of 3 from top: " + search); // 2

        // === STACK USING java.util.LinkedList ===

        // Create a LinkedList to mimic stack behavior
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add elements to end (top of stack)
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        // Peek (get last element)
        System.out.println("Top (peek) using LinkedList: " + linkedList.getLast()); // 3

        // Pop (remove last element)
        linkedList.removeLast();
        System.out.println("LinkedList after pop: " + linkedList); // [1, 2]

        // Size of the stack
        System.out.println("Size using LinkedList: " + linkedList.size()); // 2

        // Check if empty
        System.out.println("Is LinkedList empty? " + linkedList.isEmpty()); // false

        // === STACK USING java.util.ArrayList ===

        // Create an ArrayList to mimic stack behavior
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Push elements (add to end)
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Peek (look at last element)
        System.out.println("Top (peek) using ArrayList: " + arrayList.get(arrayList.size() - 1)); // 3

        // Pop (remove last element)
        arrayList.remove(arrayList.size() - 1);
        System.out.println("ArrayList after pop: " + arrayList); // [1, 2]
    }
}

