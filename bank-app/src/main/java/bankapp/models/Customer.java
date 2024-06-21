package bankapp.models;

import java.sql.SQLException;

public class Customer extends Person {

    public Customer(String name, String cpf) throws SQLException {
        super(name, cpf);
        super.setRole("customer");
    }
}
