package academy.javapro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalInStreams {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 120));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));
        students.add(new Student("David", 23));

        double averageAge = students.stream()
                .map(Student::getAge)
                .filter(age-> age > 20)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average age of students over 20 : " + averageAge);

        Optional<Student> oldestStudent = students.stream()
                .reduce(
                        ((student1, student2) ->
                                student1.getAge() > student2.getAge()
                                        ? student1 : student2)
                );

        oldestStudent.ifPresent(student -> System.out.println("Student name is : " + student.getName()));
    }
}
