package Topic5.databases.controllers;

import Topic5.databases.model.Course;
import Topic5.databases.model.Student;
import Topic5.databases.service.CourseService;
import Topic5.databases.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Optional<Student> student = Optional.ofNullable(studentService.getStudentById(studentId));
        if (student.isPresent()) {
            return ResponseEntity.ok().body(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping({"/{studentId}"})
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId,
                                               @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @DeleteMapping({"/{studentId}"})
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Long studentID) {
        studentService.deleteStudent(studentID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(
            @RequestParam Student student){
        return new ResponseEntity<>(studentService.insert(student), HttpStatus.OK);
    }

}
