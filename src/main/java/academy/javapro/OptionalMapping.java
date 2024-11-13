package academy.javapro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMapping {
    public static Optional<Student> findStudent(List<Student> students, String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));

        Optional<Student> foundStudent = findStudent(students, "Alice");

        Optional<String> upperCaseName = foundStudent.map(s -> s.getName().toUpperCase());

        upperCaseName.ifPresent(name -> System.out.println("Uppercase name: " + name));
    }
}
