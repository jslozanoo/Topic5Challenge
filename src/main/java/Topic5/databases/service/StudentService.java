package Topic5.databases.service;


import Topic5.databases.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudentById(Long id);
    Student insert(Student student);
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);



}
