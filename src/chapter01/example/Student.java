package chapter01.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private Professor advisor;
    private List<Course> courses = new ArrayList<>();
    private List<Transcript> transcripts = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Professor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.deleteStudent(this);
        }
    }

    public void advise(String message) {
        System.out.println(message);
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void addTranscript(Transcript transcript) {
        if (!transcript.getStudent().getName().equals(this.name)) {
            return;
        }

        if (courses.contains(transcript.getCourse())) {
            transcripts.add(transcript);
        }
    }
}
