package academy.javapro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CombiningOptionals {
    private static final List<Student> students = new ArrayList<>();
    private static final List<Course> courses = new ArrayList<>();

    public static Optional<Student> findStudent(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public static Optional<Course> findCourse(String title) {
        return courses.stream()
                .filter(c -> c.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public static Optional<Double> calculateAverageGrade(Optional<Student> studentOpt, Optional<Course> courseOpt) {
        return studentOpt.flatMap(student ->
                courseOpt.flatMap(course ->
                        Optional.of(computeAverageGrade(student, course))
                )
        );
    }

    private static double computeAverageGrade(Student student, Course course) {
        // Simplified grade computation
        return 85.5;
    }

    public static void main(String[] args) {
        students.add(new Student("Alice", 20));
        courses.add(new Course("Java 101"));

        Optional<Student> student = findStudent("Alice");
        Optional<Course> course = findCourse("Java 101");

        Optional<Double> averageGrade = calculateAverageGrade(student, course);

        averageGrade.ifPresent(grade -> System.out.println("Average grade: " + grade));
    }
}
