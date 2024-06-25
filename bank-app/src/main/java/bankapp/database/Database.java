package bankapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bankapp.models.Account;
import bankapp.models.CurrentAccount;
import bankapp.models.Customer;
import bankapp.models.Employee;
import bankapp.models.Manager;
import bankapp.models.Person;
import bankapp.models.SavingsAccount;

public class Database {
    // private static final String USER = "root";
    // private static final String PASSWORD = "positivo";
    private static final String URL = "jdbc:mysql://localhost:3306/bankapp";
    private static final String USER = "lucas";
    private static final String PASSWORD = "@8800MySQLof";
    private Connection connection = null;

    public void connect() { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao estabelecer a conexão!");
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
    }

    public void addPerson(String name, String cpf, String role) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String insert = "INSERT INTO PERSON (PERSON_NAME, CPF, PERSON_ROLE) VALUES (\""+name+"\",\""+cpf+"\",\""+role+"\")";
        statement.executeUpdate(insert);

        disconnect();
    }

    public void addAccount(String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance, String accountType, double cdb, double previousIncome, double totalIncome) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String insert = "INSERT INTO ACCOUNTS (ACCOUNT_USER, ACCOUNT_PASSWORD, OWNER_NAME, OWNER_CPF, OWNER_ROLE, BALANCE, ACCOUNT_TYPE, CDB, PREVIOUS_INCOME, TOTAL_INCOME) VALUES (\""+user+"\",\""+password+"\",\""+ownerName+"\",\""+ownerCpf+"\",\""+ownerRole+"\","+balance+",\""+accountType+"\","+cdb+","+previousIncome+","+totalIncome+")";
        statement.executeUpdate(insert);

        disconnect();
    }

    public void addOperation(int accountNumber, String operation, double value) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String insert = "INSERT INTO OPERATIONS (ACCOUNT_NUMBER, OPERATION_TYPE, OPERATION_VALUE) VALUES ("+accountNumber+",\""+operation+"\","+value+")";
        statement.executeUpdate(insert);

        disconnect();
    }

    public void deletePerson(String cpf) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String delete = "DELETE FROM PERSON WHERE CPF = "+cpf;
        statement.executeUpdate(delete);

        disconnect();
    }

    public void deleteAccount(int accountNumber) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String delete = "DELETE FROM ACCOUNTS WHERE ACCOUNT_NUMBER = "+accountNumber;
        statement.executeUpdate(delete);

        disconnect();
    }
    
    public void setData(int accountNumber, double balance, double cdb, double previous, double totalIncome) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String update = "UPDATE ACCOUNTS SET BALANCE = "+balance+", CDB = "+cdb+", PREVIOUS_INCOME = "+previous+", TOTAL_INCOME = "+totalIncome+" WHERE ACCOUNT_NUMBER = "+accountNumber;
        statement.executeUpdate(update);

        disconnect();
    }

    public ArrayList<Account> getAccounts() throws SQLException {
        connect();

        ArrayList<Account> accounts = new ArrayList<>();
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM ACCOUNTS";

        ResultSet result = statement.executeQuery(select);

        while (result.next()) {
            int accountNumber = result.getInt("ACCOUNT_NUMBER");
            String user = result.getString("ACCOUNT_USER");
            String password = result.getString("ACCOUNT_PASSWORD");
            String ownerName = result.getString("OWNER_NAME");
            String ownerCpf = result.getString("OWNER_CPF");
            String ownerRole = result.getString("OWNER_ROLE");
            double balance = result.getDouble("BALANCE");
            String accountType = result.getString("ACCOUNT_TYPE");
            double cdb = result.getDouble("CDB");
            double previousIncome = result.getDouble("PREVIOUS_INCOME");
            double totalIncome = result.getDouble("TOTAL_INCOME");

            Account account;
            if (accountType.equals("current")) {
                account = new CurrentAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance, previousIncome, cdb, totalIncome);
            } else {
                account = new SavingsAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance);
            }

            accounts.add(account);
        }

        disconnect();
        System.out.println("Database | Tabela de contas sincronizada");
        return accounts;
    }

    public ArrayList<Person> getPeople() throws SQLException {
        connect();

        ArrayList<Person> people = new ArrayList<Person>();
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM PERSON";

        ResultSet result = statement.executeQuery(select);

        while (result.next()) {
            String name = result.getString("PERSON_NAME");
            String role = result.getString("PERSON_ROLE");
            String cpf = result.getString("CPF");

            Person person;
            if(role.equals("manager")) {
                person = new Manager(name, cpf);
            } else if (role.equals("employee")) {
                person = new Employee(name, cpf);
            } else {
                person = new Customer(name, cpf);
            }

            people.add(person);
        }

        disconnect();
        System.out.println("Database | Tabela de usuários sincronizada");
        return people;
    }

    public int getLastAccountNumber() throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String select = "SELECT * FROM ACCOUNTS";

        ResultSet result = statement.executeQuery(select);

        int last = 0;

        while (result.next()) {
            int accountNumber = result.getInt("ACCOUNT_NUMBER");
            if (accountNumber > last) last = accountNumber;
        }

        disconnect();
        return last;
    }

    public Account auth(String user, String password) throws SQLException {
        connect();
        Account account = null;

        Statement statement = connection.createStatement();
        String select = "SELECT * FROM ACCOUNTS";

        ResultSet result = statement.executeQuery(select);

        while (result.next()) {
            int accountNumber = result.getInt("ACCOUNT_NUMBER");
            String databaseUser = result.getString("ACCOUNT_USER");
            String databasePassword = result.getString("ACCOUNT_PASSWORD");
            String ownerName = result.getString("OWNER_NAME");
            String ownerCpf = result.getString("OWNER_CPF");
            String ownerRole = result.getString("OWNER_ROLE");
            double balance = result.getDouble("BALANCE");
            String accountType = result.getString("ACCOUNT_TYPE");
            double cdb = result.getDouble("CDB");
            double previousIncome = result.getDouble("PREVIOUS_INCOME");
            double totalIncome = result.getDouble("TOTAL_INCOME");

            if (databaseUser.equals(user) && databasePassword.equals(password)) {
                if (accountType.equals("current")) {
                    account = new CurrentAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance, previousIncome, cdb, totalIncome);
                } else {
                    account = new SavingsAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance);
                }
            }
        }

        disconnect();
        return account;
    }

}
  