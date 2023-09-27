/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package student;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

// Test class for the StudentManager class using JUnit 4.
public class StudentManagerTest {
    
    private StudentManager studentManager;

    // Set up the initial state for each test case.
    @Before
    public void setUp() {
        studentManager = new StudentManager();
    }

    // Test case to verify saving and searching for a student.
    @Test
    public void testSaveAndSearchStudent() {
        // Create a new student and save it.
        Student student = new Student("1", "Dylan Munsami", 18, "dylan.munsami.17@gmail.com", "Science");
        studentManager.saveStudent(student);
        
        // Search for the saved student.
        Student foundStudent = studentManager.searchStudent("1");
        
        // Assertions to verify that the student was found and has the correct name.
        assertNotNull(foundStudent);
        assertEquals("Dylan Munsami", foundStudent.getStudentName());
    }

    // Test case to verify searching for a non-existing student.
    @Test
    public void testSearchStudent_StudentNotFound() {
        // Search for a student with ID "2" which should not exist.
        Student foundStudent = studentManager.searchStudent("2");
        
        // Assertion to verify that the student is not found.
        assertNull(foundStudent);
    }

    // Test case to verify deleting a student.
    @Test
    public void testDeleteStudent() {
        // Create a new student and save it.
        Student student = new Student("3", "Monkey D. Luffy", 22, "luffy@gmail.com", "Natural Science");
        studentManager.saveStudent(student);

        // Delete the saved student.
        boolean deleted = studentManager.deleteStudent("3");
        
        // Assertions to verify that the student was deleted and cannot be found.
        assertTrue(deleted);
        Student deletedStudent = studentManager.searchStudent("3");
        assertNull(deletedStudent);
    }

    // Test case to verify deleting a non-existing student.
    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Delete a student with ID "4" which should not exist.
        boolean deleted = studentManager.deleteStudent("4");
        
        // Assertion to verify that the deletion is unsuccessful.
        assertFalse(deleted);
    }

    // Test case to verify the age of a valid student.
    @Test
    public void testStudentAge_StudentAgeValid() {
        // Create a new student with a valid age and save it.
        Student student = new Student("5", "Trafalgar Law", 19, "trafalgar.17@gmail.com", "Geography");
        studentManager.saveStudent(student);

        // Search for the saved student.
        Student foundStudent = studentManager.searchStudent("5");
        
        // Assertions to verify that the student was found and has the correct age.
        assertNotNull(foundStudent);
        assertEquals(19, foundStudent.getStudentAge());
    }

    // Test case to verify the age of an invalid student (age below 16).
    @Test(expected = IllegalArgumentException.class)
    public void testStudentAge_StudentAgeInvalid() {
        // Create a new student with an invalid age and attempt to save it.
        Student student = new Student("6", "Son Goku", 14, "saiyanGoku@gmail.com", "PE");
        studentManager.saveStudent(student);
    }

    // Test case to verify handling of invalid age input (non-numeric).
    @Test(expected = NumberFormatException.class)
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Create a new student with a non-numeric age and attempt to save it.
        Student student = new Student("7", "Dylan", Integer.parseInt("dyl"), "Dylan@gmail.com", "History");
        studentManager.saveStudent(student);
    }
}
