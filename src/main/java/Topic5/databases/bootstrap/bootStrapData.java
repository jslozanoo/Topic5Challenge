package Topic5.databases.bootstrap;

import Topic5.databases.model.Course;
import Topic5.databases.model.Student;
import Topic5.databases.repositories.CourseRepository;
import Topic5.databases.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData  implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Dependency injection by constructor
    public bootStrapData(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    /*
      When spring implements this component, that's going to bring into the Spring context (who
      manage the beans). Context will do Dependency Injection into the constructor for an instance
      of both repositories
     */

    @Override
    public void run(String... args) throws Exception {
        Student juan = new Student("Juan Lozano", 3232917907L ,"Calle 5");
        Course calculus = new Course("Calculus", "Science");

        juan.getCourses().add(calculus);
        calculus.getStudents().add(juan);

        studentRepository.save(juan);
        courseRepository.save(calculus);

        Student sofi = new Student("Sofia Acosta", 3153102345L ,"Av Mariscal");
        Course guitar = new Course("guitar", "Music");

        sofi.getCourses().add(guitar);
        guitar.getStudents().add(sofi);

        studentRepository.save(sofi);
        courseRepository.save(guitar);

        Student julian = new Student("Julian Lozano", 52543234L ,"Av Mointagne");
        Course programming = new Course("Databases", "Science");

        julian.getCourses().add(programming);
        programming.getStudents().add(julian);

        studentRepository.save(julian);
        courseRepository.save(programming);

        Student kat = new Student("katherin Acosta", 3214232453L ,"Av Villavicencio");
        Course familyLaw = new Course("Family law", "Law");

        kat.getCourses().add(familyLaw);
        familyLaw.getStudents().add(kat);

        studentRepository.save(kat);
        courseRepository.save(familyLaw);
    }
}
