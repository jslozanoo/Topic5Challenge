package Topic5.databases.service;

import Topic5.databases.model.Course;
import Topic5.databases.model.Student;
import Topic5.databases.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> courses.add(course));
        return courses;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Course courseToUpdate = getCourseById(id);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setFaculty(course.getFaculty());
        courseRepository.save(courseToUpdate);

    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);

    }
}
