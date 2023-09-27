/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

/*
 * The Student class represents an individual student with distinct attributes.
 * These attributes include a unique identifier, name, age, email, and enrolled course.
 */
class Student {
    
    // Class attributes or member variables
    
    // Unique identifier for the student
    private String studentId;
    
    // Name of the student
    private String studentName;
    
    // Age of the student
    private int studentAge;
    
    // Email address of the student
    private String studentEmail;
    
    // Course in which the student is enrolled
    private String studentCourse;

 
    public Student(String studentId, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    // Getter method to retrieve the student's ID
    // @return The unique identifier of the student.
    public String getStudentId() {
        return studentId;
    }

    // Getter method to retrieve the student's name
    // @return The name of the student.
    public String getStudentName() {
        return studentName;
    }

    // Getter method to retrieve the student's age
    // @return The age of the student.
    public int getStudentAge() {
        return studentAge;
    }

    // Getter method to retrieve the student's email
    // @return The email address of the student.
    public String getStudentEmail() {
        return studentEmail;
    }

    // Getter method to retrieve the student's course
    // @return The course in which the student is enrolled.
    public String getStudentCourse() {
        return studentCourse;
    }
}
