/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */// Import necessary classes for managing students and user input
package student;
import java.util.List;
import java.util.Scanner;

// The main class that drives the student management application
public class Main {
    public static void main(String[] args) {
        // Create a new instance of StudentManager to manage student data
        StudentManager studentManager = new StudentManager();
        // Create a Scanner object to handle user input
        Scanner scanner = new Scanner(System.in);

        // Main loop of the application
        while (true) {
            // Display the main menu
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*********************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            System.out.println("*********************************************");

            // Get user input
            String input = scanner.nextLine();

            // Check if the user wants to exit
            if (!input.equals("1")) {
                System.out.println("Exiting application. ");
                break;
            }

            // If the user enters '1', show the application menu
            showMenu(studentManager, scanner);
        }
        // Close the Scanner to avoid resource leaks
        scanner.close();
    }

    // Method to display the main menu and handle user choices
    private static void showMenu(StudentManager studentManager, Scanner scanner) {
        // Display menu options in a loop until the user chooses to exit
        while (true) {
            System.out.println("Please select one of the following items:");
            System.out.println("1. Capture new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit application");

            // Get user choice
            String choice = scanner.nextLine();

            // Process the user's choice
            switch (choice) {
                case "1":
                    // Allow the user to capture details for a new student
                    captureNewStudent(studentManager, scanner);
                    break;
                case "2":
                    // Allow the user to search for a student by ID
                    searchStudent(studentManager, scanner);
                    break;
                case "3":
                    // Allow the user to delete a student by ID
                    deleteStudent(studentManager, scanner);
                    break;
                case "4":
                    // Print a report of all students
                    printStudentReport(studentManager);
                    break;
                case "5":
                    // Exit the application
                    exitApplication();
                    break;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to capture details for a new student
    private static void captureNewStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("*************************************************");
        System.out.println("Capture a new student");
        System.out.println("*************************************************");
        System.out.print("Enter the student id: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();
        int studentAge;
        // Validate and capture student age, ensuring it's 16 or greater
        while (true) {
            try {
                System.out.print("Enter the student's age: ");
                studentAge = Integer.parseInt(scanner.nextLine());
                if (studentAge >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age! Age must be 16 or greater.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age.");
            }
        }
        // Capture other student details
        System.out.print("Enter the student's email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Enter the student's course: ");
        String studentCourse = scanner.nextLine();

        // Create a new Student object with the captured details
        Student newStudent = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        // Save the new student in the StudentManager
        studentManager.saveStudent(newStudent);
        System.out.println("Student details have been successfully saved.");
    }

    // Method to search for a student by ID
    private static void searchStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("*************************************************");
        System.out.println("Search for a student");
        System.out.println("*************************************************");

        // Prompt the user to enter a student ID to search for
        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine();

        // Search for the student in the StudentManager
        Student foundStudent = studentManager.searchStudent(searchId);

        // Display the found student's details or a message if not found
        if (foundStudent != null) {
            System.out.println("*******************************");
            System.out.println("Student ID: " + foundStudent.getStudentId());
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student Age: " + foundStudent.getStudentAge());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Student Course: " + foundStudent.getStudentCourse());
            System.out.println("*******************************");
        } else {
            System.out.println("Student with student ID " + searchId + " not found.");
        }
    }

    // Method to delete a student by ID
    private static void deleteStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("*************************************************");
        System.out.println("Delete a student");
        System.out.println("*************************************************");
        System.out.print("Enter Student ID to delete: ");

        // Get the student ID to delete
        String deleteId = scanner.nextLine();

        // Checks to see if the input is a valid number
        if (isNumeric(deleteId)) {
            // Flag to track whether the student was found for deletion
            boolean studentFoundForDeletion = false;

            // Get the list of all students
            List<Student> students = studentManager.getAllStudents();

            // Iterate through the students to find the one with the specified ID
            for (Student student : students) {
                if (student.getStudentId().equals(deleteId)) {
                    studentFoundForDeletion = true;
                    // Display student details and prompt for confirmation
                    System.out.println("*********************************************");
                    System.out.println("Student details found:");
                    System.out.println("ID: " + student.getStudentId());
                    System.out.println("Name: " + student.getStudentName());
                    System.out.println("Age: " + student.getStudentAge());
                    System.out.println("Email: " + student.getStudentEmail());
                    System.out.println("Course: " + student.getStudentCourse());

                    // Prompt for confirmation to delete the student
                    System.out.print("Do you want to delete this student? (yes/no): ");
                    String confirmDelete = scanner.nextLine().toLowerCase();

                    // Process the confirmation
                    if (confirmDelete.equals("yes")) {
                        // Delete the student from the StudentManager
                        studentManager.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student was not deleted.");
                    }

                    // Exit the loop since the student has been found
                    break;
                }
            }

            // If the student was not found for deletion, display a message
            if (!studentFoundForDeletion) {
                System.out.println("Student with ID " + deleteId + " not found.");
            }
        } else {
            // Display an error message if the input is not a valid student ID
            System.out.println("Invalid input. Please enter a valid student ID.");
        }
    }

    // Helper method to check if a string is a numeric value
    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    // Method to print a report of all students
    private static void printStudentReport(StudentManager studentManager) {
        // Get the list of all students
        List<Student> students = studentManager.getAllStudents();

        // Display a report header
        System.out.println("Student Report");
        System.out.println("*******************************");

        // Counter for numbering students
        int studentCount = 1;

        // Iterate through the students and display their details
        for (Student student : students) {
            System.out.println("Student " + studentCount);
            System.out.println("*******************************");
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Student Age: " + student.getStudentAge());
            System.out.println("Student Email: " + student.getStudentEmail());
            System.out.println("Student Course: " + student.getStudentCourse());
            System.out.println("----------------------------------");

            // Increment the student count
            studentCount++;
        }
    }

    // Method to exit the application
    private static void exitApplication() {
        System.out.println("Exiting application.");
        // Terminate the program
        System.exit(0);
    }
}
