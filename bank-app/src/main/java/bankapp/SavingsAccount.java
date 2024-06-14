package bankapp;

public class SavingsAccount extends Account {
    private double income = 1.005;
    private double previous = 0;
    private double cdb = 0;
    private double totalIncome = 0;

    public SavingsAccount(Person person) {
        super(person);
    }

    public void investOnCDB(double value) {
        if (value > this.balance) {
            System.out.println("Insuficient Balance");
        } else if (value <= 0) {
            System.out.println("Invalid value.");
        } else {
            super.balance -= value;
            this.previous = value;
            this.cdb += value;
            System.out.println("You applied " + value + " on CDB, your new CDB balance is: " + this.cdb);
        }
    }

    public void getAccount() {
        System.out.println("--------ACCOUNT INFORMATIONS--------");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
        System.out.println(String.format("CDB Balance: %.2f", this.cdb));
        System.out.println(String.format("Total Income: %.2f", this.totalIncome));
        System.out.println(income);
        System.out.println("------Owner data------");
        this.owner.getPerson();
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
