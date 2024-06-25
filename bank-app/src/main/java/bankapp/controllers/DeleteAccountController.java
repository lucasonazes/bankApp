package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.views.DeleteAccountView;
import bankapp.database.Database;
import bankapp.models.Session;
import bankapp.models.Account;

public class DeleteAccountController {
    private DeleteAccountView view;
    private Database database = new Database();
    private Session session = Session.getInstance(null, null);

    public DeleteAccountController() {
        view = new DeleteAccountView();
        view.setVisible(true);

        this.view.getDeleteAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteAccount();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void deleteAccount() throws SQLException {
        int accountNumber = view.getAccountNumber();
        
        Account account = session.bank.getAccount(accountNumber);
        session.bank.deleteAccount(account);
        database.deleteAccount(accountNumber);
        view.showMessage("Conta excluída com sucesso!");
        view.dispose();
    }
}
