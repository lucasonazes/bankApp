package bankapp.models;

import java.sql.SQLException;

import bankapp.database.Database;

public class Account {
    private int accountNumber;
    private String user;
    private String password;
    private String ownerName;
    private String ownerCpf;
    private String ownerRole;
    private double balance = 0;
    private String type;
    private Database database = new Database();

    public Account(String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance) throws SQLException {
        this.accountNumber = database.getLastAccountNumber() + 1;
        this.user = user;
        this.password = password;
        this.ownerName = ownerName;
        this.ownerCpf = ownerCpf;
        this.ownerRole = ownerRole;
        this.balance = balance;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerCpf() {
        return ownerCpf;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public String getType() {
        return type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setType(String type) {
        this.type = type;
    }
}
