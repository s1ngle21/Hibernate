package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void delete(Long id);
    void update(Long id, Student student);
    List<Student> getAll();
    Student getById(Long id);


}
