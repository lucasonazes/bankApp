package bankapp.models;

import java.sql.SQLException;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String user, String password, String ownerName, String ownerCpf, String ownerRole, double balance) throws SQLException {
        super(accountNumber, user, password, ownerName, ownerCpf, ownerRole, balance);
        super.setType("savings");
    }

    public void saveDB() throws SQLException {
        super.database.addAccount(super.getUser(), super.getPassword(), super.getOwnerName(), super.getOwnerCpf(), super.getOwnerRole(), super.getBalance(), super.getType(), 0, 0, 0);
    }
}
