package bankapp.models;

import java.sql.SQLException;

import bankapp.database.Database;

public class Manager extends Person {
    private Database database = new Database();

    public Manager(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("manager");
        database.addPerson(name, cpf, super.getRole());
    }
}
