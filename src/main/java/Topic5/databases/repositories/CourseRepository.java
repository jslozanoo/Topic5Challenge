package Topic5.databases.repositories;

import Topic5.databases.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    //This give us all the CRUD operations

}
