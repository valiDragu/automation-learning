package Tema8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
    public static void main() {
//        Device device = new Device();
//        device.powerOn();
//
//        Phone phone = new Phone();
//        phone.powerOn();
//        phone.call();
//
//        Account user1 = new Account("test");
//        user1.login();
//
//        AdminAccount user2 = new AdminAccount("Tester", "admin");
//        user2.login();
//        user2.deleteUser();
//
//        Course course1 = new Course("Java crash course", 2);
//        course1.getCourse();
//
//        OnlineCourse course2 = new OnlineCourse("Python fundamentals", 2, "online");
//        course2.getCourse();
//
//
//        Notification notification1 = new Notification();
//        notification1.send();
//
//        EmailNotification notification2 = new EmailNotification("test@example.com" + ".");
//        notification2.send();

//        Order order1 = new Order(12345);
//        order1.printOrder();
//
//        OnlineOrder order2 = new OnlineOrder(54321);
//        order2.trackOrder();
//        order2.printOrder();

        LoginPage login = new LoginPage();
        login.setDriver();
        login.openUrl("https://www.example.com");
        login.login("test", "pass123");
    }
}
