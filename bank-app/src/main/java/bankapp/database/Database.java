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
    public Statement statement = null;
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

    public void showPerson() throws SQLException {
        connect();

        statement = connection.createStatement();

        String select = "SELECT * FROM PERSON";

        result = statement.executeQuery(select);

        while (result.next()) {
            String name = result.getString("PERSON_NAME");
            String role = result.getString("PERSON_ROLE");
            String cpf = result.getString("CPF");
            System.out.println("NOME: " + name);
            System.out.println("CPF: " + cpf);
            System.out.println("CARGO: " + role);
        }

        disconnect();
    }
}

