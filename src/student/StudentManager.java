/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// This class is  a Student Manager that manages a list of students.
public class StudentManager {
    
    // List to store student objects
    private List<Student> students = new ArrayList<>(); 

    // Saves a student object to the list.

    public void saveStudent(Student student) {
        students.add(student);
    }

    // Searches for a student by their student ID.

    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Deletes a student by their student ID.
 
    public boolean deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Retrieves a list of all students.
   
    public List<Student> getAllStudents() {
        return students;
    }
}
