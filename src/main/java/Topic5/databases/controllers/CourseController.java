package Topic5.databases.controllers;

import Topic5.databases.model.Course;
import Topic5.databases.repositories.CourseRepository;
import Topic5.databases.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable Long courseId) {
        Optional<Course> course = Optional.ofNullable(courseService.getCourseById(courseId));
        if (course.isPresent()) {
            return ResponseEntity.ok().body(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping({"/{courseId}"})
    public ResponseEntity<Course> updateCourse(@PathVariable("courseId") Long courseId,
                                               @RequestBody Course course) {
        courseService.updateCourse(courseId, course);
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }

    @DeleteMapping({"/{courseId}"})
    public ResponseEntity<Course> deleteCourse(@PathVariable("courseId") Long courseID) {
        courseService.deleteCourse(courseID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Course> saveCourse(
            @RequestParam Course course){
        return new ResponseEntity<>(courseService.insert(course), HttpStatus.OK);
    }
}



