package org.example.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {

        // Create an empty LinkedList of Integers
        LinkedList<Integer> list = new LinkedList<>(); // Time: O(1)

        // Add elements to the end of the list
        list.add(1); // Adds 1 to the end → [1], Time: O(1)
        list.add(2); // Adds 2 to the end → [1, 2], Time: O(1)
        list.add(3); // Adds 3 to the end → [1, 2, 3], Time: O(1)

        // Access element at index 1
        // Since LinkedList doesn't support random access, this is O(n)
        System.out.println(list.get(1)); // Output: 2, Time: O(n)

        // Add an element at the beginning of the list
        list.addFirst(0); // List becomes → [0, 1, 2, 3], Time: O(1)

        // Add an element at the end of the list
        list.addLast(4); // List becomes → [0, 1, 2, 3, 4], Time: O(1)

        // Print current state of list
        System.out.println(list); // Output: [0, 1, 2, 3, 4]

        // Remove element at index 3 (value = 3)
        list.remove(3); // Removes the 4th element (index 3) → [0, 1, 2, 4], Time: O(n)

        // Print updated list
        System.out.println(list); // Output: [0, 1, 2, 4]

        /**
         * Remove all even elements from the list.
         * This loops through the list and removes items satisfying the condition.
         */
        list.removeIf(x -> x % 2 == 0); // Removes 0, 2, 4 → Remaining: [1]
        // Time Complexity: O(n)

        // Print final integer list
        System.out.println(list); // Output: [1]

        /**
         * Create LinkedList of strings from an array.
         * Arrays.asList returns a fixed-size list, which is copied into a new LinkedList to allow modification.
         */
        LinkedList<String> stringLinkedList = new LinkedList<>(
                Arrays.asList("Apple", "Banana", "Grapes")
        ); // Time: O(n)

        LinkedList<String> linkedList = new LinkedList<>(
                Arrays.asList("Apple", "Watermelon")
        ); // Time: O(n)

        /**
         * Remove all elements from stringLinkedList that are present in linkedList.
         * Performs contains check for each element in the parameter list.
         * For each element in linkedList (m), checks in stringLinkedList (n) → O(m * n)
         */
        stringLinkedList.removeAll(linkedList); // Removes "Apple"
        // Result: [Banana, Grapes]

        // Print updated string list
        System.out.println(stringLinkedList); // Output: [Banana, Grapes]

        // Remove a specific element by value
        stringLinkedList.remove("Grapes"); // Removes "Grapes" → [Banana], Time: O(n)

        // Print final state of string list
        System.out.println(stringLinkedList); // Output: [Banana]
    }
}
