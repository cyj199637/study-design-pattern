package chapter01.example;

import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args) {
        Student student1 = new Student("student1");
        Student student2 = new Student("student2");

        Course course1 = new Course("1", "course1");
        Course course2 = new Course("2", "course2");

        student1.registerCourse(course1);
        student1.registerCourse(course2);
        student2.registerCourse(course1);

        Transcript transcript1 = new Transcript(student1, course1, LocalDateTime.now(), Grade.A);
        Transcript transcript2 = new Transcript(student1, course2, LocalDateTime.now(), Grade.B);
        Transcript transcript3 = new Transcript(student2, course1, LocalDateTime.now(), Grade.B);
        Transcript transcript4 = new Transcript(student2, course2, LocalDateTime.now(), Grade.C);

        System.out.println(student1.getName());
        for (var t : student1.getTranscripts()) {
            System.out.println(t.getCourse().getName() + " " + t.getGrade());
        }

        System.out.println(student2.getName());
        for (var t : student2.getTranscripts()) {
            System.out.println(t.getCourse().getName() + " " + t.getGrade());
        }
    }
}
