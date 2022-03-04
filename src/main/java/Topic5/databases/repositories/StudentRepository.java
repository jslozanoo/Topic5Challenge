package Topic5.databases.repositories;

import Topic5.databases.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    // This give us all the CRUD operations

}
