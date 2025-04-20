package org.example.vector;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Demonstrates various operations with the Vector class in Java,
 * including capacity management, initialization from collections,
 * clearing, accessing elements, and thread-safe usage.
 */
public class Demo {
    public static void main(String[] args) {

        // Create a Vector with initial capacity 5 and capacity increment 3
        Vector<Integer> list = new Vector<>(5, 3);

        // Add 5 elements (fills initial capacity)
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        // Print capacity after initial fills (should be 5)
        System.out.println(list.capacity()); // Output: 5

        // Adding one more element increases capacity by 3
        list.add(1);
        System.out.println(list.capacity()); // Output: 8

        // Add 2 more elements (fills up to current capacity)
        list.add(1);
        list.add(1);
        System.out.println(list.capacity()); // Output: 8

        // Adding one more triggers another capacity increment
        list.add(1);
        System.out.println(list.capacity()); // Output: 11

        // Initialize a LinkedList and add elements
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // Create a Vector initialized with contents of a LinkedList
        Vector<Integer> vector1 = new Vector<>(linkedList);
        System.out.println(vector1); // Output: [1, 2, 3]

        // Access elements using a loop
        for (int i = 0; i < vector1.size(); i++) {
            System.out.println(vector1.get(i));
        }

        // Clear all elements from vector1
        vector1.clear();
        System.out.println(vector1); // Output: []

        // Demonstrate thread-safe behavior of Vector
        Vector<Integer> vector = new Vector<>();

        // Thread t1 adds 0 to 999 to the vector
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });

        // Thread t2 adds 0 to 999 to the vector
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final size of the vector (should be 2000 if thread-safe)
        System.out.println("Size of thread-safe vector: " + vector.size());

        // Just for demonstration, printing size of earlier 'list' vector
        System.out.println("Size of list: " + list.size());
    }
}
