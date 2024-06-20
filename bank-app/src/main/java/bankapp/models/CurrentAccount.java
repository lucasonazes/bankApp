package bankapp.models;

import java.sql.SQLException;

public class CurrentAccount extends Account {
    private double income = 1.005;
    private double previous = 0;
    private double cdb = 0;
    private double totalIncome = 0;

    public CurrentAccount(String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance, double previous, double cdb, double totalIncome) throws SQLException {
        super(user, password, ownerName, ownerCpf, ownerRole, balance);
        super.setType("current");
        this.previous = previous;
        this.cdb = cdb;
        this.totalIncome = totalIncome;
    }

    public void investOnCDB(double value) {
        if (value > getBalance()) {
            System.out.println("Insuficient Balance");
        } else if (value <= 0) {
            System.out.println("Invalid value.");
        } else {
            double finalBalance = super.getBalance() - value;
            super.setBalance(finalBalance);
            this.previous = value;
            this.cdb += value;
            System.out.println("You applied " + value + " on CDB, your new CDB balance is: " + this.cdb);
        }
    }

    public void days(int days) {
        if (days == 1) {
            System.out.println(days + " day has passed....");
        } else {
            System.out.println(days + " days has passed....");
        }

        for (int i = 1; i <= days; i++) {
            this.cdb = this.cdb * income;
        }

        System.out.println(String.format("Previous value: %.2f", this.previous));
        this.totalIncome += this.cdb - this.previous;
        double income = this.cdb - this.previous;
        System.out.println(String.format("Income: %.2f", income));
        System.out.println(String.format("Your new CDB balance is: %.2f", this.cdb));

        this.previous = this.cdb;
    }
}
