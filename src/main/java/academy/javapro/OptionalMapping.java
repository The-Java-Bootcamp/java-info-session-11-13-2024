package academy.javapro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMapping {
    public static Optional<Student> findStudent(List<Student> students, String name){
        return students.
                stream().
                filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));
        students.add(new Student("Alice", 27));

        Optional<Student> foundStudent = findStudent(students, "Suresh");
        Optional<String> upperCaseName = foundStudent.map(s-> s.getName().toUpperCase());
        // System.out.println("Student name is : "+ upperCaseName );
        upperCaseName.ifPresent(name-> System.out.println("Name is " + name));
    }
}
