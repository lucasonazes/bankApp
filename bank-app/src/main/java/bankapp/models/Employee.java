package bankapp.models;

import java.sql.SQLException;

public class Employee extends Person {

    public Employee(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("employee");
    }
}
