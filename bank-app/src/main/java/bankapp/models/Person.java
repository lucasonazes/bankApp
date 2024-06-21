package bankapp.models;

import java.sql.SQLException;

import bankapp.database.Database;

public class Person {
    private String name;
    private String role;
    private String cpf;
    private Database database = new Database();

    public Person(String name, String cpf) throws SQLException {
        this.name = name;
        this.cpf = cpf;
    }
    
    public void saveDB() throws SQLException {
        database.addPerson(name, cpf, role);
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
