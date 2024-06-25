package bankapp.models;

import java.util.ArrayList;

public class Session {
    private static Session instance;
    public Account account;
    public Bank bank;
    public Log log = new Log();

    private Session(Account account, Bank bank) {
        this.account = account;
        this.bank = bank;
    }

    public static Session getInstance(Account account, Bank bank) {
        if (instance == null) {
            instance = new Session(account, bank);
        }
        return instance;
    }

    public Account getAccount() {
        return account;
    }

    public void clear() {
        instance = null;
    }

    public boolean verifyCpf(String cpf) {
        ArrayList<Person> people = this.bank.getPeople();

        for (Person person : people) {
            if (person.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyUser(String user) {
        ArrayList<Account> accounts = this.bank.getAccounts();

        for (Account account : accounts) {
            if (account.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String cpf) {
        ArrayList<Person> people = this.bank.getPeople();

        for (Person person : people) {
            if (person.getCpf().equals(cpf)) {
                return person;
            }
        }
        return null;
    }
}
