package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.models.Session;
import bankapp.views.ManageAccountView;
import bankapp.views.ShowAccountsView;

public class ManageAccountController {
    private ManageAccountView view;
    private Session session = Session.getInstance(null, null);

    public ManageAccountController() {
        view = new ManageAccountView();
        view.setVisible(true);

        this.view.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
    
        this.view.getManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageAccount();
            }
        });

        this.view.getCreatePerson().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPerson();
            }
        });

        this.view.getDeletePerson().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePerson();
            }
        });

        this.view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
            }
        });

        this.view.getShowAccounts().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showAccounts();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAccount();
            }
        });
    }

    private void createAccount() {
        new CreateAccountController();
    }

    private void manageAccount() {
        new OperationsController();
    }

    private void createPerson() {
        new CreatePersonController();
    }

    private void deletePerson() {
        new DeletePersonController();
    }

    private void deleteAccount() {
        new DeleteAccountController();
    }

    private void showAccounts() throws SQLException {
        session.log.info("Usuário "+session.account.getUser()+" consultou contas ativas no banco");
        new ShowAccountsView();
    }

    private void exitAccount() {
        this.view.dispose();
        session.log.info("Usuário "+session.account.getUser()+" realizou logout");
    }
}
