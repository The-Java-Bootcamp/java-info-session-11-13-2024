package academy.javapro;

import java.util.ArrayList;
import java.util.List;

public class TraditionalStudentFinder {

    public static Student findStudent(List<Student> students, String name){
        for(Student s : students){
            if(s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 22));

        Student found = findStudent(students, "Suresh");
        System.out.println(found.getName());
    }
}
