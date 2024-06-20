package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.views.CreateAccountView;
import bankapp.views.SetAccountTypeView;

public class CreateAccountController {
    private SetAccountTypeView setAccountTypeView;
    private CreateAccountView createAccountView = new CreateAccountView();
    private String type = null;

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
                createAccount();
            }
        });
    }

    public void createAccount() {
        createAccountView.showMessage("Conta criada com sucesso!");
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
