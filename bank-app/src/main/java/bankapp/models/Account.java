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
    protected Database database = new Database();

    public Account(int accountNumber, String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance) throws SQLException {
        
        this.accountNumber = accountNumber;
        this.user = user;
        this.password = password;
        this.ownerName = ownerName;
        this.ownerCpf = ownerCpf;
        this.ownerRole = ownerRole;
        this.balance = balance;
    }

    public int deposit(double value) {
        try {
            if (value <= 0) return 1;
            
            this.balance += value;
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    public int withdraw(double value) {
        try {
            if (this.balance < value) {
                return 1;
            } else if (value <= 0) return 2;

            this.balance -= value;
            return 0;
        } catch (Exception e) {
            return -1;
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

    public String getOwnerRole() {
        return ownerRole;
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
