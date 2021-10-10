package chapter01.example;

import java.time.LocalDateTime;

public class Transcript {
    private Student student;
    private Course course;
    private LocalDateTime date;
    private Grade grade;

    public Transcript(Student student, Course course, LocalDateTime date, Grade grade) {
        this.student = student;
        this.course = course;
        student.addTranscript(this);
        course.addTranscript(this);
        this.date = date;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Grade getGrade() {
        return grade;
    }
}
