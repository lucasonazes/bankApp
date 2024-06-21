package bankapp.models;

import java.sql.SQLException;
import java.util.ArrayList;

import bankapp.database.Database;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Person> people = new ArrayList<>();
    private Database database = new Database();

    public Bank() throws SQLException {
        accounts = database.getAccounts();
        people = database.getPeople();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void deleteAccount(int accountNumber) {
        this.accounts.remove(accountNumber);
        System.out.println("Account deleted sucessfuly");
    }
}
