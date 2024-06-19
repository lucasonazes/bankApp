package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bankapp.views.*;

public class BankController {
    private LoginView loginView;
    private ManageAccountView manageAccountView;
    // private Bank model;

    public BankController(LoginView loginView) {
        this.loginView = loginView;
        // model = new Bank();

        this.loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String user = loginView.getUser();
        String password = loginView.getPassword();

        if(password.equals("3")) {
            loginView.showMessage("Bem-vindo, " + user);
            ManageAccountView ManageAccountView = new ManageAccountView();
        } else loginView.showMessage("Senha incorreta");
    }
}
