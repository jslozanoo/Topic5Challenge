package Topic5.databases.service;

import Topic5.databases.model.Student;
import Topic5.databases.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student studentToUpdate = getStudentById(id);
        studentToUpdate.setName(student.getName());
        studentToUpdate.setAddress(student.getAddress());
        studentRepository.save(studentToUpdate);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
