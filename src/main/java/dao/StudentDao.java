package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, Student updatedStudent);
    List<Student> getAllStudents();
    Student getStudentById(Long id);


}
