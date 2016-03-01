package com.az.dev.ocp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        App application = new App();

        application.testInvariantsByUsingAssertion(); // Test Invariants by Using Assertions
        application.moreAssertions();
        
        application.multiCatchMethod(); // Develop Code That Handles Multiple Exception Types in a Single catch Block

        application.tryWithResourcesMethod(); // try-with-resources Statement (Including Using Classes That Implement the AutoCloseable Interface)

        application.userInput.close();
    }
    
    private void testInvariantsByUsingAssertion() {
        System.out.println("USING ASSERTIONS");
        addSepparator();
        
        System.out.print("Enter your name (First character should be UPPERCASE!)\t:\t");
        String name = userInput.nextLine();
        checkFirstChar(name); // Using really-simple method
        
        System.out.print("Enter your age (Only from 0-120 allowed)\t\t:\t");
        int age = userInput.nextInt();
        assertAge(age); // Using simple method
        
        addSepparator();
    }
    
    private void checkFirstChar(String name) {
        assert (Character.isUpperCase(name.charAt(0)));
    }

    private void assertAge(int age) {
        assert (age <= 120) : "Invalid age " + age;
    }

    private void moreAssertions() throws Exception {
        int x = 1;
        boolean b = true;

        Organization organization = new Organization();

        assert (x == 1);
        assert (b);
        assert (b) : b;
        assert true;
        assert (x == 1) : x;
        assert (x == 1) : aReturnMethod();
        assert (x == 1) : new Employee();
        assert (x == 1) : organization;

        organization.close(); // closes the organization Closeable
    }

    private String aReturnMethod() {
        return "Value";
    }
    
    private void multiCatchMethod() {

        System.out.println("\nCATCH MULTIPLE EXCEPTIONS");
        addSepparator();

        System.out.print("Type 'io' or 'sql' to throw an IO or SQL exception\t:\t");
        String exceptionType = userInput.next();

        try {
            if (exceptionType.equals("io")) {
                throw new IOException();
            }
            if (exceptionType.equals("sql")) {
                throw new SQLException();
            }
        } catch (IOException | SQLException e) {
            System.out.println("Type of exception caught\t\t\t\t:\t" + e.getClass().getName());
        }

        addSepparator();
    }

    private void tryWithResourcesMethod() {
        System.out.println(
            "\nTRY-WITH-RESOURCES STATEMENTS (Including Using Classes That Implement the AutoCloseable Interface)");
        addSepparator();

        try (Employee employee = new Employee(); Organization organization = new Organization()) {
            System.out.println("Press enter to throw an Exception");
            waitForUserInput();
            throw new IOException();
        } catch (Exception e) {
            System.out.println(e.getClass().getName() + " Exception caught");
        } finally {
            System.out.println("In finally clause, cleaning up...");
        }
    }

    private void waitForUserInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addSepparator() {
        System.out.println(
            "------------------------------------------------------------------------------------------------------");
    }
}
