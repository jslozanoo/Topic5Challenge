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

    // Dependecy injection by constructor
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

        Student kat = new Student("katherin Acosta", 3214232453L ,"Av Villav");
        Course familyLaw = new Course("Family law", "Law");

        kat.getCourses().add(familyLaw);
        familyLaw.getStudents().add(kat);

        studentRepository.save(kat);
        courseRepository.save(familyLaw);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of courses: " + courseRepository.count());

    }
}
