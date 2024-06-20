package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.views.DeleteAccountView;
import bankapp.database.Database;

public class DeleteAccountController {
    private DeleteAccountView view;
    private Database database = new Database();

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
        
        database.deleteAccount(accountNumber);
        view.showMessage("Usuário excluído com sucesso!");
        view.dispose();
    }
}
