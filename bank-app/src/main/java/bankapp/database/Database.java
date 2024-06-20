package bankapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // private static final String USER = "root";
    // private static final String PASSWORD = "positivo";
    private static final String URL = "jdbc:mysql://localhost:3306/bankapp";
    private static final String USER = "lucas";
    private static final String PASSWORD = "@8800MySQLof";
    private Connection connection = null;
    public ResultSet result = null;

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

    public void addAccount(String user, String password, String ownerName, String ownerCpf, double balance, String accountType, double cdb, double previousIncome, double totalIncome) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String insert = "INSERT INTO ACCOUNTS (ACCOUNT_USER, ACCOUNT_PASSWORD, OWNER_NAME, OWNER_CPF, BALANCE, ACCOUNT_TYPE, CDB, PREVIOUS_INCOME, TOTAL_INCOME) VALUES (\""+user+"\",\""+password+"\",\""+ownerName+"\",\""+ownerCpf+"\",\""+balance+"\",\""+accountType+"\",\""+cdb+"\",\""+previousIncome+"\",\""+totalIncome+"\")";
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
        String delete = "DELETE FROM PERSON WHERE ACCOUNT_NUMBER = "+accountNumber;
        statement.executeUpdate(delete);

        disconnect();
    }
    
    public void operation(int accountNumber, double balance) throws SQLException {
        connect();

        Statement statement = connection.createStatement();
        String update = "UPDATE ACCOUNTS SET BALANCE = "+balance+" WHERE ACCOUNT_NUMBER = "+accountNumber;
        statement.executeUpdate(update);

        disconnect();
    }

}

