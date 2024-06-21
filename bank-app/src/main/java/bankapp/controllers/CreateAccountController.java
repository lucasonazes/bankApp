package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.CurrentAccount;
import bankapp.models.SavingsAccount;
import bankapp.views.CreateAccountView;
import bankapp.views.SetAccountTypeView;

public class CreateAccountController {
    private SetAccountTypeView setAccountTypeView;
    private CreateAccountView createAccountView = new CreateAccountView();
    private String type = null;
    private Database database = new Database();

    public CreateAccountController() {
        setAccountTypeView = new SetAccountTypeView();
        setAccountTypeView.setVisible(true);

        this.setAccountTypeView.getCurrentAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAccountTypeView.dispose();
                currentAccount();
            }
        });

        this.setAccountTypeView.getSavingsAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAccountTypeView.dispose();
                savingsAccount();
            }
        });

        this.createAccountView.getCreateAccountButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createAccount();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void createAccount() throws SQLException {
        int accountNumber = database.getLastAccountNumber() + 1;
        String user = createAccountView.getUser();
        String password = createAccountView.getPassword();
        String ownerName = createAccountView.getOwnerName();
        String ownerCpf = createAccountView.getOwnerCpf();
        String ownerRole = createAccountView.getOwnerRole();

        if (type == "current") {
            CurrentAccount currentAccount = new CurrentAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, 0, 0, 0, 0);

            currentAccount.saveDB();

            createAccountView.showMessage("Conta corrente criada com sucesso!");
            createAccountView.dispose();
        } else if (type == "savings") {
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, user, password, ownerName, ownerCpf, ownerRole, 0);

            savingsAccount.saveDB();

            createAccountView.showMessage("Conta poupança criada com sucesso!");
            createAccountView.dispose();
        } else createAccountView.showMessage("Erro ao criar conta");
    }

    public void currentAccount() {
        createAccountView.setVisible(true);
        this.type = "current";
    }

    public void savingsAccount() {
        createAccountView.setVisible(true);
        this.type = "savings";
    }
}
