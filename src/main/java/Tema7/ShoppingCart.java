package Tema7;

public class ShoppingCart {
    double totalPrice = 0;

    public void addProduct(double price) {
        if(price <=0) {
            System.out.println("Can't add product with negative price");
        } else {
            totalPrice += price;
        }
    }

    public void removeProduct(double price) {
       if (totalPrice == 0 || price >= totalPrice || price <=0) {
           System.out.println("Invalid operation");
       } else {
           totalPrice -= price;
       }
    }

    public void getTotal() {
        System.out.println("Shopping cart's total price is: " + totalPrice);
    }

    public static void main() {
        ShoppingCart p1 = new ShoppingCart();
        p1.addProduct(10.1);
        p1.addProduct(10);
        p1.addProduct(1);
        p1.removeProduct(-9);
        p1.getTotal();
    }
}
