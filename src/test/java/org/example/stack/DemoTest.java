package org.example.stack;

import junit.framework.TestCase; // Make sure this import is present

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DemoTest extends TestCase {

    // --- Tests for java.util.Stack ---

    public void testStackPush() {
        Stack<Integer> stack = new Stack<>();
        assertTrue("Stack should be empty initially", stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("Stack size should be 3 after pushes", 3, stack.size());
        assertEquals("Top element should be 3", Integer.valueOf(3), stack.peek()); // Use Integer.valueOf for clarity with Object comparison
        assertFalse("Stack should not be empty after pushes", stack.isEmpty());
    }

    public void testStackPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30); // Top


        assertEquals(3, stack.size());
        Integer poppedElement = stack.pop();

        assertEquals("Popped element should be 30", Integer.valueOf(30), poppedElement);
        assertEquals("Stack size should be 2 after pop", 2, stack.size());
        assertEquals("New top element should be 20", Integer.valueOf(20), stack.peek());
    }

    public void testStackPopEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        try {
            stack.pop();
            fail("Pop on empty stack should throw EmptyStackException"); // Fail if no exception is thrown
        } catch (EmptyStackException expected) {
            // Exception was expected, test passes for this part
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testStackPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(15); // Top

        assertEquals(2, stack.size());
        Integer topElement = stack.peek();

        assertEquals("Peek should return the top element 15", Integer.valueOf(15), topElement);
        assertEquals("Stack size should remain 2 after peek", 2, stack.size());
        assertEquals("Calling peek again should return the same element", Integer.valueOf(15), stack.peek()); // Verify again
    }

    public void testStackPeekEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        try {
            stack.peek();
            fail("Peek on empty stack should throw EmptyStackException");
        } catch (EmptyStackException expected) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testStackIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue("New stack should be empty", stack.isEmpty());
        stack.push(1);
        assertFalse("Stack should not be empty after push", stack.isEmpty());
        stack.pop();
        assertTrue("Stack should be empty after popping the only element", stack.isEmpty());
    }

    public void testStackSize() {
        Stack<Integer> stack = new Stack<>();
        assertEquals("Initial size should be 0", 0, stack.size());
        stack.push(1);
        stack.push(2);
        assertEquals("Size should be 2 after two pushes", 2, stack.size());
        stack.pop();
        assertEquals("Size should be 1 after one pop", 1, stack.size());
    }

    public void testStackSearch() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10); // Position 4
        stack.push(20); // Position 3
        stack.push(30); // Position 2
        stack.push(40); // Position 1 (Top)

        assertEquals("Search for top element (40) should return 1", 1, stack.search(40));
        assertEquals("Search for element 20 should return 3", 3, stack.search(20));
        assertEquals("Search for bottom element (10) should return 4", 4, stack.search(10));
        assertEquals("Search for non-existent element (99) should return -1", -1, stack.search(99));
    }


    // --- Tests for java.util.LinkedList used as a Stack ---

    public void testLinkedListPushAndPeek() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue("List should be empty initially", list.isEmpty());

        list.addLast(1); // Push
        list.addLast(2); // Push
        list.addLast(3); // Push

        assertEquals("List size should be 3 after pushes", 3, list.size());
        assertEquals("Last element (peek) should be 3", Integer.valueOf(3), list.getLast());
        assertFalse("List should not be empty after pushes", list.isEmpty());
    }

    public void testLinkedListPop() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30); // Top

        assertEquals(3, list.size());
        Integer poppedElement = list.removeLast(); // Pop

        assertEquals("Popped element should be 30", Integer.valueOf(30), poppedElement);
        assertEquals("List size should be 2 after pop", 2, list.size());
        assertEquals("New last element (peek) should be 20", Integer.valueOf(20), list.getLast());
    }

    public void testLinkedListPopEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        try {
            list.removeLast();
            fail("removeLast on empty list should throw NoSuchElementException");
        } catch (NoSuchElementException expected) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testLinkedListPeek() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(5);
        list.addLast(15); // Top

        assertEquals(2, list.size());
        Integer topElement = list.getLast(); // Peek

        assertEquals("Peek should return the last element 15", Integer.valueOf(15), topElement);
        assertEquals("List size should remain 2 after peek", 2, list.size());
        assertEquals("Calling getLast again should return the same element", Integer.valueOf(15), list.getLast());
    }

    public void testLinkedListPeekEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        try {
            list.getLast();
            fail("getLast on empty list should throw NoSuchElementException");
        } catch (NoSuchElementException expected) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testLinkedListIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue("New list should be empty", list.isEmpty());
        list.addLast(1);
        assertFalse("List should not be empty after addLast", list.isEmpty());
        list.removeLast();
        assertTrue("List should be empty after removing the only element", list.isEmpty());
    }

    public void testLinkedListSize() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals("Initial size should be 0", 0, list.size());
        list.addLast(1);
        list.addLast(2);
        assertEquals("Size should be 2 after two addLast calls", 2, list.size());
        list.removeLast();
        assertEquals("Size should be 1 after one removeLast", 1, list.size());
    }


    // --- Tests for java.util.ArrayList used as a Stack ---

    public void testArrayListPushAndPeek() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue("List should be empty initially", list.isEmpty());

        list.add(1); // Push
        list.add(2); // Push
        list.add(3); // Push

        assertEquals("List size should be 3 after pushes", 3, list.size());
        assertEquals("Last element (peek) should be 3", Integer.valueOf(3), list.get(list.size() - 1));
        assertFalse("List should not be empty after pushes", list.isEmpty());
    }

    public void testArrayListPop() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30); // Top

        assertEquals(3, list.size());
        Integer poppedElement = list.remove(list.size() - 1); // Pop

        assertEquals("Popped element should be 30", Integer.valueOf(30), poppedElement);
        assertEquals("List size should be 2 after pop", 2, list.size());
        assertEquals("New last element (peek) should be 20", Integer.valueOf(20), list.get(list.size() - 1));
    }

    public void testArrayListPopEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        try {
            list.remove(list.size() - 1); // This will try to access index -1
            fail("remove(size-1) on empty list should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testArrayListPeek() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15); // Top

        assertEquals(2, list.size());
        Integer topElement = list.get(list.size() - 1); // Peek

        assertEquals("Peek should return the last element 15", Integer.valueOf(15), topElement);
        assertEquals("List size should remain 2 after peek", 2, list.size());
        assertEquals("Calling get(size-1) again should return the same element", Integer.valueOf(15), list.get(list.size() - 1));
    }

    public void testArrayListPeekEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        try {
            list.get(list.size() - 1); // This will try to access index -1
            fail("get(size-1) on empty list should throw IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e);
        }
    }

    public void testArrayListIsEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue("New list should be empty", list.isEmpty());
        list.add(1);
        assertFalse("List should not be empty after add", list.isEmpty());
        list.remove(list.size() - 1);
        assertTrue("List should be empty after removing the only element", list.isEmpty());
    }

    public void testArrayListSize() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals("Initial size should be 0", 0, list.size());
        list.add(1);
        list.add(2);
        assertEquals("Size should be 2 after two adds", 2, list.size());
        list.remove(list.size() - 1);
        assertEquals("Size should be 1 after one remove", 1, list.size());
    }

} // End of DemoTest class