package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.views.CreateAccountView;
import bankapp.views.SetAccountTypeView;

public class CreateAccountController {
    private SetAccountTypeView setAccountTypeView;
    private CreateAccountView createAccountView;
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
    }

    public void currentAccount() {
        CreateAccountView createAccountView = new CreateAccountView();
        createAccountView.setVisible(true);
        this.type = "current";
    }

    public void savingsAccount() {
        CreateAccountView createAccountView = new CreateAccountView();
        createAccountView.setVisible(true);
        this.type = "savings";
    }
}
