package Tema8;

public class Course {
    private String courseName;
    private int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void getCourse() {
        System.out.println("Course name: " + courseName);
        System.out.println("Course duration: "  + duration);
    }
}
