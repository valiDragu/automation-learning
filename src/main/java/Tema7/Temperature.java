package Tema7;

public class Temperature {

    double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public double toFahrenheit(double celsius) {
        return celsius * 9/5 + 32;
    }

    public double toKelvin(double celsius) {
        return celsius + 273.15;
    }

    public void getCelsius() {
        System.out.println("Temperature in Celsius: " + celsius);
    }

    public void getFahrenheit() {
        System.out.println("Temperature in Fahrenheit: " + toFahrenheit(celsius));
    }

    public void getKelvin() {
        System.out.println("Temperature in Kelvin: " + toKelvin(celsius));
    }

    public static void main() {
        Temperature t1 = new Temperature(0);
        t1.getCelsius();
        t1.getFahrenheit();
        t1.getKelvin();
    }
}
