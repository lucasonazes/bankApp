package bankapp.models;

import java.sql.SQLException;

public class Person {
    protected String name;
    protected String role;
    protected String cpf;

    public Person(String name, String cpf) throws SQLException {
        this.name = name;
        this.cpf = cpf;
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
