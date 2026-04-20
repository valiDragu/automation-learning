package Tema8;

public class Order {
    protected int orderId;

    public Order (int orderId) {
        this.orderId = orderId;
    }

    public void printOrder() {
        System.out.println("OrderId: " + orderId);
    }

    public static void main() {
        OnlineOrder order3 = new OnlineOrder(19876);
        order3.trackOrder();
        order3.printOrder();
    }
}
