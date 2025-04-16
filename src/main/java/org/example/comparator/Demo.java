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
        studentList.add(new Student(102, "Priya"));

        // Sort students using a custom Comparator by name
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println("\nSorted Students by Name using Comparator:");
        System.out.println(studentList);
    }
}
