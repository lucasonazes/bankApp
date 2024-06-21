package bankapp.models;

import java.sql.SQLException;

public class Manager extends Person {

    public Manager(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("manager");
    }
}
