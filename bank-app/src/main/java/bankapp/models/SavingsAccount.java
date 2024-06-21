package bankapp.models;

import java.sql.SQLException;

public class SavingsAccount extends Account {

    public SavingsAccount(String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance) throws SQLException {
        super(user, password, ownerName, ownerCpf, ownerRole, balance);
        super.setType("savings");
        super.database.addAccount(user, password, ownerName, ownerCpf, ownerRole, balance, super.getType(), 0, 0, 0);
    }
}
