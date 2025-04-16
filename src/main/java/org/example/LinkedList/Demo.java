package org.example.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {

        // Create an empty LinkedList of Integers
        LinkedList<Integer> list = new LinkedList<>(); // Time: O(1)

        // Add elements to the end of the list
        list.add(1); // O(1)
        list.add(2); // O(1)
        list.add(3); // O(1)

        // Get element at index 1
        // Note: LinkedList access by index is O(n), so this is O(n) here
        System.out.println(list.get(1)); // Output: 2, Time: O(n)

        // Add an element at the beginning
        list.addFirst(0); // Output: [0, 1, 2, 3], Time: O(1)

        // Add an element at the end
        list.addLast(4); // Output: [0, 1, 2, 3, 4], Time: O(1)

        // Print the full list
        System.out.println(list); // Output: [0, 1, 2, 3, 4]

        /**
         * Remove elements that match a condition.
         * In this case: remove all even numbers.
         * The removeIf internally iterates through the list and removes matching elements.
         */
        list.removeIf(x -> x % 2 == 0); // Removes 0, 2, 4 → Output: [1, 3]
        // Time Complexity: O(n)

        System.out.println(list); // Output: [1, 3]

        /**
         * Create LinkedList from Array using Arrays.asList()
         * Note: Arrays.asList returns a fixed-size list, but we wrap it with new LinkedList to make it mutable
         */
        LinkedList<String> stringLinkedList = new LinkedList<>(
                Arrays.asList("Apple", "Banana", "Grapes")
        ); // Time: O(n)

        LinkedList<String> linkedList = new LinkedList<>(
                Arrays.asList("Apple", "Watermelon")
        ); // Time: O(n)

        /**
         * Remove all elements from stringLinkedList that are present in linkedList
         * This performs a contains check for each element in linkedList.
         * Time Complexity: O(m * n), where m = size of linkedList, n = size of stringLinkedList
         */
        stringLinkedList.removeAll(linkedList); // Removes "Apple"
        // After removal → Output: [Banana, Grapes]

        System.out.println(stringLinkedList); // Output: [Banana, Grapes]
    }
}
