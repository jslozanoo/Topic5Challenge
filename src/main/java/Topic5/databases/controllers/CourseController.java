package Topic5.databases.controllers;

import Topic5.databases.model.Course;
import Topic5.databases.repositories.CourseRepository;
import Topic5.databases.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllStudents(){
        List<Course> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    // Implement the remaining methods
}
