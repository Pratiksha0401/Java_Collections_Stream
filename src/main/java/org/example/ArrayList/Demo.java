package org.example.ArrayList;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Add elements
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Add at specific index
        list.add(1, "JavaScript");

        // Print the list
        System.out.println("List after additions: " + list);

        // Get element at index
        System.out.println("Element at index 2: " + list.get(2));

        // Set element at index
        list.set(2, "Go");
        System.out.println("List after set: " + list);

        // Remove element by index
        list.remove(1);
        System.out.println("List after removing index 1: " + list);

        // Remove element by value
        list.remove("Go");
        System.out.println("List after removing 'Go': " + list);

        // Contains
        System.out.println("Contains 'Java'? " + list.contains("Java"));

        // Index of element
        System.out.println("Index of 'Java': " + list.indexOf("Java"));

        // Last index of element
        list.add("Java");
        System.out.println("Last index of 'Java': " + list.lastIndexOf("Java"));

        // Size of list
        System.out.println("Size of list: " + list.size());

        // Convert to array
        Object[] arr = list.toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        // Sublist
        List<String> sub = list.subList(0, 2);
        System.out.println("Sublist (0 to 2): " + sub);

        // Using iterator
        System.out.print("Using Iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Using ListIterator (forward and backward)
        ListIterator<String> lit = list.listIterator();
        System.out.print("ListIterator forward: ");
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println();

        System.out.print("ListIterator backward: ");
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        // Check if empty
        System.out.println("Is list empty? " + list.isEmpty());

        // Ensure capacity (optional optimization)
        list.ensureCapacity(20);

        // Trim capacity to current size
        list.trimToSize();

        // Equals
        ArrayList<String> anotherList = new ArrayList<>(list);
        System.out.println("Lists equal? " + list.equals(anotherList));

        // Clear list
        list.clear();
        System.out.println("List after clear: " + list);
        System.out.println("Is list empty now? " + list.isEmpty());
    }
}

