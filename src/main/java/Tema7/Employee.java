package Tema7;

public class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        if(name == null || name.isEmpty()) {
            System.out.println("Please provide a valid name");
        } else {
            this.name = name;
        }

        if (salary <= 0 ) {
            System.out.println("Salary must be higher than 0");
        } else {
            this.salary = salary;
        }
    }

    public void increaseSalary(double percent) {
        if(percent <= 0) {
            System.out.println("Provide a number higher than 0");
        }  else {
            salary += salary * (percent / 100);
        }
    }

    public void getSalary() {
        if ((name == null || name.isEmpty()) || salary <= 0) {
            System.out.println("Please provide a valid name and/or salary.");
        } else {
            System.out.println(name +"'s current salary is: " + salary);
        }
    }

    public static void main() {
        Employee e1 = new Employee("Ana", 6500);
        Employee e2 = new Employee("Emma", 2550);
        e1.getSalary();
        e2.increaseSalary(3);
        e2.getSalary();
    }
}
