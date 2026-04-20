package Tema8;

public class OnlineCourse extends Course {
    private String platform;

    public OnlineCourse(String courseName, int duration, String platform) {
        super(courseName, duration);
        this.platform = platform;
    }

    @Override
    public void getCourse() {
        super.getCourse();
        System.out.println("Platform: " + platform);
    }
}
