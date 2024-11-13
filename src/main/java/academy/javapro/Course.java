package academy.javapro;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String title;
    private final List<Student> students = new ArrayList<>();

    public Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
