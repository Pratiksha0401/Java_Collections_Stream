package org.example.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Demonstrates usage of CopyOnWriteArrayList and ArrayList in multithreaded environments.
 * Highlights the difference in behavior during read/write operations.
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * ==========================
         * COPYONWRITEARRAYLIST BASICS
         * ==========================
         *
         * "Copy on Write" means that every time you modify the list (add/remove),
         * it creates a new copy of the underlying array and applies the change to that copy.
         *
         * ➤ This allows safe iteration even while another thread is modifying the list.
         * ➤ Suitable for use cases where reads are frequent and writes are infrequent.
         */

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // (No operations here but declared to show how CopyOnWriteArrayList is initialized)

        /**
         * Read Operations: Fast and non-blocking, done on the current snapshot of the list.
         * Write Operations: Slower, as a new copy of the entire list is made.
         * Example analogy:
         *      - Imagine you have a file "notepad.txt".
         *      - When you edit it, a duplicate "notepad-copy.txt" is made and changed,
         *        leaving the original readable by others.
         */

        /**
         * ==========================
         * EXCEPTION SCENARIO: ArrayList during iteration
         * ==========================
         *
         * The below commented code demonstrates a scenario where modifying an ArrayList
         * during iteration throws a ConcurrentModificationException.
         *
         * You can uncomment and run this block to see the exception in action.
         */

        /**
         List<String> shoppingList1 = new ArrayList<>();
         shoppingList1.add("Milk");
         shoppingList1.add("Eggs");
         shoppingList1.add("Bread");
         System.out.println("Initial Shopping List: " + shoppingList1);

         for (String item : shoppingList1) {
         System.out.println(item);
         // Try to modify the list while reading
         if (item.equals("Eggs")) {
         shoppingList1.add("Butter"); // ❌ This will cause ConcurrentModificationException
         System.out.println("Added Butter while reading.");
         }
         }

         // Output: Will throw exception before this line
         System.out.println("Updated Shopping List: " + shoppingList1);
         */

        /**
         * ==========================
         * COPYONWRITEARRAYLIST: Safe iteration during modification
         * ==========================
         */

        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List (CopyOnWrite): " + shoppingList);

        for (String item : shoppingList) {
            System.out.println(item);
            // Modifying the list during iteration is safe
            if (item.equals("Eggs")) {
                shoppingList.add("Butter"); // ✅ No exception
                System.out.println("Added Butter while reading.");
            }
        }

        // Output includes "Butter" added during iteration
        System.out.println("Updated Shopping List: " + shoppingList);


        /**
         * ==========================
         * MULTITHREADING WITH ARRAYLIST (Not Thread-Safe)
         * ==========================
         * Shows how ArrayList behaves when multiple threads read and write at the same time.
         * This can cause:
         * - Exceptions
         * - Inconsistent state
         */

        List<String> sharedArrayList = new ArrayList<>();
        sharedArrayList.add("Item1");
        sharedArrayList.add("Item2");
        sharedArrayList.add("Item3");

        Thread readerArrayThread = new Thread(() -> {
            try {
                while (true) {
                    for (String item : sharedArrayList) {
                        System.out.println("Reading from ArrayList: " + item);
                        Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in ArrayList reader thread: " + e);
            }
        });

        Thread writerArrayThread = new Thread(() -> {
            try {
                Thread.sleep(500); // Let reader start first
                sharedArrayList.add("Item4"); // ❌ Unsafe
                System.out.println("Added Item4 to ArrayList.");

                Thread.sleep(500);
                sharedArrayList.remove("Item1"); // ❌ Unsafe
                System.out.println("Removed Item1 from ArrayList.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readerArrayThread.start();
        writerArrayThread.start();


        /**
         * ==========================
         * MULTITHREADING WITH COPYONWRITEARRAYLIST (Thread-Safe)
         * ==========================
         * Safe to use in concurrent environments without external synchronization.
         * Internally handles read-write separation by copying.
         */

        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");

        Thread readerThread = new Thread(() -> {
            try {
                while (true) {
                    for (String item : sharedList) {
                        System.out.println("Reading from CopyOnWriteList: " + item);
                        Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in CopyOnWrite reader thread: " + e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(500);
                sharedList.add("Item4"); // ✅ Safe
                System.out.println("Added Item4 to CopyOnWriteList.");

                Thread.sleep(500);
                sharedList.remove("Item1"); // ✅ Safe
                System.out.println("Removed Item1 from CopyOnWriteList.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readerThread.start();
        writerThread.start();
    }
}
