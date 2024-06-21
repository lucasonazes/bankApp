package bankapp.models;

import java.sql.SQLException;

import bankapp.database.Database;

public class Customer extends Person {
    private Database database = new Database();

    public Customer(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("customer");
        database.addPerson(name, cpf, getRole());
    }
}
