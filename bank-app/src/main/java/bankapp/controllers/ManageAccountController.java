package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.views.ManageAccountView;

public class ManageAccountController {
    private ManageAccountView view;

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
                try {
                    deletePerson();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
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

    private void deletePerson() throws SQLException {
        new DeletePersonController();
    }

    private void deleteAccount() {
        new DeleteAccountController();
    }

    private void exitAccount() {
        this.view.dispose();
    }
}
