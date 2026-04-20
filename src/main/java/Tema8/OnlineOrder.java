package Tema8;

public class OnlineOrder  extends Order {

    public OnlineOrder (int orderId) {
        super(orderId);
    }

    public void trackOrder() {
        System.out.println("Tracking " + orderId);
    }

    public static void main() {
        Order order4 = new Order(98765);
        order4.printOrder();
//        order4.trackOrder(); //won't work

        OnlineOrder order5 = new OnlineOrder(7654);
        order5.trackOrder();
        order5.printOrder();
    }
}
