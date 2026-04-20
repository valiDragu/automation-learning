package Tema8;

public class EmailNotification extends Notification {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void getEmailAddress() {
        System.out.println("Email address: " + emailAddress);
    }

    @Override
    public void send() {
        System.out.println("Notification sent to " + emailAddress);
    }
}
