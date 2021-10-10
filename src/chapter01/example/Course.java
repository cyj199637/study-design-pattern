package chapter01.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String id;
    private String name;
    private List<Student> students = new ArrayList<>();
    private Integer numOfStudents = 0;

    private List<Transcript> transcripts = new ArrayList<>();

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Integer getNumOfStudents() {
        return numOfStudents;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            numOfStudents = students.size();
        }
    }

    public void deleteStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            numOfStudents = students.size();
        }
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void addTranscript(Transcript transcript) {
        if (!transcript.getCourse().getName().equals(this.getName())) {
            return;
        }

        if (students.contains(transcript.getStudent())) {
            transcripts.add(transcript);
        }
    }
}
