
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Bank santander = new Bank("Santander");
        Person user = new Person("Lucas", 18, "12345678910", "123");
        //Person user2 = new Person("Miguel", 45, "1245", "321");
        SavingsAccount account = new SavingsAccount(user);
        //SavingsAccount account2 = new SavingsAccount(user2);

        // Adding account to the bank
        //santander.addAccount(account);
        // santander.addAccount(account2);

        // Operations
     
        // account.withDraw(50);
        // account.investOnCDB(100);
        // account.days(5);
        // account.days(10);

        // Bank
        //santander.manageAccount(123, "deposit", 1000);
        account.deposit(1);
        // santander.deleteAccount(0);

        santander.getAccounts();
    }
}
