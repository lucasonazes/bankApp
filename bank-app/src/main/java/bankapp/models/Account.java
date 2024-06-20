package bankapp.models;

public class Account {
    private static int globalNumber = 1;
    protected int accountNumber;
    protected double balance = 0;
    protected Person owner;

    @SuppressWarnings("static-access")
    public Account(Person person) {
        this.globalNumber = this.globalNumber + 1;
        this.accountNumber = this.globalNumber;
        this.owner = person;
    }

    public void getAccount() {
        System.out.println("--------------------------------");
        System.out.println("------ACCOUNT INFORMATIONS------");
        System.out.println("--------------------------------");
        System.out.println("Account number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
        System.out.println("------Owner data------");
        this.owner.getPerson();
    }

    public void deposit(double value) {
        if (value <= 0) {
            System.out.println("Invalid value.");
        } else {
            this.balance += value;
            System.out.println("Your deposit was made sucessfully, your new balance is: " + this.balance);
        }
    }

    public void withDraw(double value) {
        if (this.balance < value) {
            System.out.println("Insuficient balance");
        } else if (value <= 0) {
            System.out.println("Invalid value.");
        } else {
            this.balance -= value;
            System.out.println("Your withDraw was made sucessfully, your new balance is: " + this.balance);
        }
    }

    public Person getOwner() {
        return this.owner;
    }

    public double getBalance() {
        return this.balance;
    }
}
