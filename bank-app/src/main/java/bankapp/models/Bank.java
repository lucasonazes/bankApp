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

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Account getAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public Person getPerson(String cpf) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getCpf().equals(cpf)) {
                return person;
            }
        }
        return null;
    } 

    public void deleteAccount(Account account) {
        this.accounts.remove(account);
    }

    public void deletePerson(Person person) {
        this.people.remove(person);
    }
}
