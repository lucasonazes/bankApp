package bankapp.models;

public class Session {
    private static Session instance;
    private Account account;
    public Bank bank;

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

    public int getAccountNumber() {
        return account.getAccountNumber();
    }

    public void clear() {
        instance = null;
    }
}
