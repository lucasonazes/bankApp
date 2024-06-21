package bankapp.models;

import java.sql.SQLException;

import bankapp.database.Database;

public class Employee extends Person {
    private Database database = new Database();

    public Employee(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("employee");
        database.addPerson(name, cpf, super.getRole());
    }
}
