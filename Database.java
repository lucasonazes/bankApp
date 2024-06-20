import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public String url = "jdbc:mysql://localhost:3306/javadatabase";
    public String user = "root";
    public String password = "positivo";
    public Connection connection = null;
    public Statement statement = null;
    public ResultSet result = null;

    public Database() {}

    public void addPerson(String name, int age, String rg, String cpf) {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Recording JDBC driver
            connection = DriverManager.getConnection(url, user, password);

            // Establishing connection with the database
            statement = connection.createStatement();

            String insert = "INSERT INTO PERSON (PERSON_FULL_NAME, PERSON_RG, PERSON_CPF) VALUES (\"" + name + "\", \""
                    + rg + "\", \"" + cpf + "\")";

            statement.executeUpdate(insert);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addAccount(Account account) {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Recording JDBC driver
            connection = DriverManager.getConnection(url, user, password);

            // Establishing connection with the database
            statement = connection.createStatement();

            Person owner = account.getOwner();

            String insert = "INSERT INTO ACCOUNTS (ACCOUNT_BALANCE, ACCOUNT_OWNER) VALUES (\"" + account.getBalance()
                    + "\", \"" + owner.getCpf() + "\")";

            statement.executeUpdate(insert);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void operation(double balance, Person owner) {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Recording JDBC driver
            connection = DriverManager.getConnection(url, user, password);

            // Establishing connection with the database
            statement = connection.createStatement();

            String update = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE = " + balance + " WHERE ACCOUNT_OWNER = "
                    + owner.getCpf();

            statement.executeUpdate(update);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectAccounts() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Recording JDBC driver
            connection = DriverManager.getConnection(url, user, password);

            // Establishing connection with the database
            statement = connection.createStatement();

            String select = "SELECT * FROM ACCOUNTS";

            result = statement.executeQuery(select);

            while (result.next()) {
                int id = result.getInt("ACCOUNT_ID");
                String balance = result.getString("ACCOUNT_BALANCE");
                String owner = result.getString("ACCOUNT_OWNER");
                System.out.println("ID: " + id);
                System.out.println("BALANCE: " + balance);
                System.out.println("OWNER_CPF: " + owner + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
