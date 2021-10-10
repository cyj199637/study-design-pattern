package chapter01.example;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void advise(int i) {
        students.get(i).advise("상담 시작");
    }
}
