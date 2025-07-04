package org.example;

public class AutoclosableTryWithResources {
    public static void main(String[] args) {
        try (MyResourceWithException res = new MyResourceWithException()) {
            res.doSomething();
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());

            // Show suppressed exceptions (like from close())
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }
}


class MyResourceWithException implements AutoCloseable {
    public void doSomething() {
        System.out.println("Doing something risky...");
        throw new RuntimeException("Exception in try block");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing with exception...");
        throw new Exception("Exception in close()");
    }
}
