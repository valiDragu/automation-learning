package Tema8;

public class Product {
    private String name;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println("Product name: " + name);
    }

    public void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Price must be higher than 0.");
        }
        this.price = price;
    }

    public void getPrice() {
        System.out.println("Price: " + price);
    }

    public static void main() {
        Product product1 = new Product();
        product1.setName("Test");
        product1.setPrice(0.01);
        product1.getName();
        product1.getPrice();
    }
}
