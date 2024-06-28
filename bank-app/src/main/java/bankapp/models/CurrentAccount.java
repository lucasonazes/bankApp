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

    public int income(int days) {
        try {
            if (days <= 0) {
                return 1;
            }
    
            for (int i = 1; i <= days; i++) {
                this.cdb = this.cdb * income;
            }

            double prev = this.cdb;
            this.cdb = this.cdb * this.income;
            this.totalIncome += this.cdb - prev;  
            return 0;
        } catch (Exception e) {
            return -1;
        }
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
