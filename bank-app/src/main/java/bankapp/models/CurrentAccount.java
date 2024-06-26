package bankapp.models;

import java.sql.SQLException;

public class CurrentAccount extends Account {
    private double income = 1.005;
    private double previous = 0;
    private double cdb = 0;
    private double totalIncome = 0;

    public CurrentAccount(int accountNumber, String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance, double previous, double cdb, double totalIncome) throws SQLException {
        super(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance);
        super.setType("current");
        this.previous = previous;
        this.cdb = cdb;
        this.totalIncome = totalIncome;
    }

    public int invest(double value) {
        try {
            if (value > getBalance()) {
                return 1;
            } else if (value <= 0) {
                return 2;
            }
            
            super.setBalance(super.getBalance() - value);
            this.previous = value;
            this.cdb += value;
            return 0;
        } catch (Exception e) {
            return -1;
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

    public double getCdb() {
        return cdb;
    }

    public double getPrevious() {
        return previous;
    }

    public double getTotalIncome() {
        return totalIncome;
    }
}
