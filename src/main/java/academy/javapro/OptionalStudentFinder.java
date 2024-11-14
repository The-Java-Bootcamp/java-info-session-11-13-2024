package academy.javapro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStudentFinder {
    public static Optional<Student> findStudent(List<Student> students, String name){
        for(Student s : students){
            if(s.getName().equalsIgnoreCase(name)){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));

        Optional<Student> foundStudent = findStudent(students, "Suresh");
        foundStudent.ifPresentOrElse(
                student -> System.out.println("Found: "+ student.getName()),
                () -> System.out.println("Student not found")
        );
    }
}
