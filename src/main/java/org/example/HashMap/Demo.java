package org.example.HashMap;

import java.util.*;

/**
 * Demonstrates various operations using Java's HashMap.
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * Creating a HashMap with initial capacity 17 and load factor 0.5
         * - Initial Capacity: Number of buckets in the HashMap
         * - Load Factor: Determines when to resize (0.5 means resize when 50% full)
         */
        HashMap<Integer, String> map = new HashMap<>(17, 0.5f);

        // Adding key-value pairs to the map
        map.put(31, "Shubham");
        map.put(11, "Akshit");
        map.put(2, "Neha");
        map.put(2, "Mehul");  // Overwrites the previous value for key 2

        // Print the entire map
        System.out.println(map);  // Output will not contain "Neha" as it was replaced by "Mehul"

        // Accessing values by key
        String student = map.get(31);  // Fetches value for key 31
        System.out.println(student);   // Output: Shubham

        String s = map.get(69);        // Key 69 doesn't exist
        System.out.println(s);         // Output: null

        // Checking key/value presence
        System.out.println(map.containsKey(2));            // true
        System.out.println(map.containsValue("Shubham"));  // true

        // Iterating through keys using keySet()
        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        // Getting the entry set and modifying values
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        // Convert all values to uppercase
        for (Map.Entry<Integer, String> entry : entries) {
            entry.setValue(entry.getValue().toUpperCase());
        }

        // Print updated map
        System.out.println(map);  // All values will be in uppercase

        // Remove key 31 only if its value is "Nitin" (does not match)
        boolean res = map.remove(31, "Nitin");
        System.out.println("REMOVED ? :" + res);  // Output: false (entry not removed)

        System.out.println(map);  // Map still contains key 31

        // Commented out removal - would remove key 31 unconditionally
        // map.remove(31);

        // Checking presence of an element in a list
        List<Integer> list = Arrays.asList(2, 4, 32, 43, 4, 432);
        list.contains(32);  // Returns true, but result is not printed or stored
    }
}
