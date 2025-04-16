package org.example.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*

Type	     Description	                                                        When to Use
Comparable	 Natural/default sorting (Employee implements Comparable<Employee>)	    Use when class has a single natural order
Comparator	 External sorting logic (EmployeeIdComparator, StudentNameComparator)	Use when you need multiple sorting criteria
Lambda Sort	 Inline custom sort: list.sort((a, b) -> b.id - a.id)	                Use for quick one-time sorting (short logic)


 */

// Class representing a Student
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Class representing an Employee
// Implements Comparable to define default (natural) sorting by ID
class Employee implements Comparable<Employee> {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Implements natural sorting logic using Comparable (ascending by ID)
    @Override
    public int compareTo(Employee o) {
        // Ternary operator to compare by ID
        return this.id == o.id ? 0 : (this.id > o.id ? 1 : -1);
    }
}

// Comparator class to sort employees by ID using ternary operator (alternative to Comparable)
class EmployeeIdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.id == e2.id ? 0 : (e1.id > e2.id ? 1 : -1);
    }
}

// Comparator class to sort students by name using ternary operator
class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.equals(s2.name) ? 0 : (s1.name.compareTo(s2.name) > 0 ? 1 : -1);
    }
}

public class Demo {
    public static void main(String[] args) {

        // Create a list of Employee objects
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(3, "Navin"));
        employeeList.add(new Employee(31, "Rani"));
        employeeList.add(new Employee(13, "Raju"));
        employeeList.add(new Employee(30, "Ankit"));

        // Sort employees using Comparable (natural order - ascending by ID)
        Collections.sort(employeeList);
        System.out.println("Sorted Employees by ID using Comparable (Ascending):");
        System.out.println(employeeList);

        // Sort using Comparator explicitly (though Comparable is already there)
        Collections.sort(employeeList, new EmployeeIdComparator());
        System.out.println("\nSorted Employees by ID using Comparator (Ascending):");
        System.out.println(employeeList);

        // Sort using Lambda expression (descending order)
        employeeList.sort((a, b) -> b.id - a.id);
        System.out.println("\nSorted Employees by ID using Lambda (Descending):");
        System.out.println(employeeList);

        // Create a list of Student objects
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101, "Zara"));
        studentList.add(new Student(105, "Amit"));
        studentList.add(new Student(103, "John"));
        studentList.add(new Student(103, "Priya"));

        // Sort students using a custom Comparator by name
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println("\nSorted Students by Name using Comparator:");
        System.out.println(studentList);

        /**
         * Comparator using method references and Comparator chaining.
         *
         * - First sorts students by `id` in descending order (`reversed()`).
         * - Then, if two students have the same `id`, sorts by `name` in ascending order.
         *
         * This is a concise and reusable way to define multi-level sorting.
         */
        Comparator<Student> comparator = Comparator
                .comparing(Student::getId)     // Sort by ID
                .reversed()                    // in descending order
                .thenComparing(Student::getName); // then by name (ascending)

        // Sorting the list using the comparator
        studentList.sort(comparator);

        // Displaying the sorted list
        System.out.println("Sorted using Comparator chain (id DESC, name ASC):");
        System.out.println(studentList);

        /**
         * Manual comparator using lambda expression and if-else logic.
         *
         * Equivalent to the above Comparator but written using explicit comparison:
         * - Sorts by ID in descending order.
         * - If IDs are equal, compares names in ascending alphabetical order.
         *
         * This form provides clear control flow and is easy to debug or extend.
         */
        studentList.sort((s1, s2) -> {
            // Compare by ID in descending order
            if (s1.id > s2.id) {
                return -1; // s1 should come before s2
            } else if (s1.id < s2.id) {
                return 1;  // s1 should come after s2
            } else {
                // If IDs are equal, compare by name in ascending order
                return s1.name.compareTo(s2.name);
            }
        });

        // Displaying the sorted list again (should be same result)
        System.out.println("\nSorted using Lambda with if-else (id DESC, name ASC):");
        System.out.println(studentList);

    }
}
