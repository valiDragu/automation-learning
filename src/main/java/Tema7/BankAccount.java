package Tema7;

public class BankAccount {

    String ownerName;
    double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount <= 0) {
            System.out.println("Deposit amount must be higher than 0");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double withdrawAmount) {
        if (balance > withdrawAmount) {
            balance -= withdrawAmount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayBalance(){
        System.out.println("Current balance is: " + balance);
    }

    public static void main() {
        BankAccount acc1 = new BankAccount("Tester", 123);
        acc1.deposit(1);
        acc1.deposit(-23);
        acc1.withdraw(124);
        acc1.displayBalance();
    }
}
