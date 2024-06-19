package bankapp.models;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String name;

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void getAccounts() {
        System.out.println("The accounts of the " + this.name + " bank" + " are:\n");

        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            account.getAccount();
        }
    }

    public void manageAccount(int accountNumber, String method, double value) {
        if (method == "limit") {
            Account manageable = this.accounts.get(accountNumber);
            manageable.depositLimit = value;
        } else {
            System.out.println("Invalid method");
        }
    }

    public void deleteAccount(int accountNumber) {
        this.accounts.remove(accountNumber);
        System.out.println("Account deleted sucessfuly");
    }
}
