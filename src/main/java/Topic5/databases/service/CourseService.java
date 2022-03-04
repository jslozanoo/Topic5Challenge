package Topic5.databases.service;

import Topic5.databases.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    Course getCourseById(Long id);
    Course insert(Course course);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);

}
