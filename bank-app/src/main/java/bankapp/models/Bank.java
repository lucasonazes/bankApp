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

    public void deleteAccount(int accountNumber) {
        this.accounts.remove(accountNumber);
        System.out.println("Account deleted sucessfuly");
    }
}
