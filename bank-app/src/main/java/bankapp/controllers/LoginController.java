package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.views.LoginView;

public class LoginController {
    private LoginView view;

    public LoginController() {
        view = new LoginView();
        view.setVisible(true);

        this.view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String user = view.getUser();
        String password = view.getPassword();

        if(password.equals("3")) {
            this.view.showMessage("Bem-vindo, " + user);
            new ManageAccountController();
        } else {
            view.showMessage("Senha incorreta");
            return;
        }
    }
}
