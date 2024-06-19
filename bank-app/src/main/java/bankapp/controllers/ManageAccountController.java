package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        System.out.println("Editar Conta");
    }

    private void deleteAccount() {
        System.out.println("Excluir Conta");
    }

    private void exitAccount() {
        this.view.dispose();
    }
}
