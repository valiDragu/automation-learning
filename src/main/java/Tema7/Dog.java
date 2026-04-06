package Tema7;

public class Dog {
        String name;
        int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void bark() {
            System.out.println("Cainele " + name + " latra");
        }

        public int getAgeInHumanYears() {
            return age * 7;
        }

        public static void main(String []args) {
            Dog dog1 = new Dog("Azorel", 2);
            Dog dog2 = new Dog("Loki", 4);

            dog1.bark();
            System.out.println(dog1.getAgeInHumanYears());

            dog2.bark();
            System.out.println(dog2.getAgeInHumanYears());
        }
}
