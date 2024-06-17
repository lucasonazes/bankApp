package bankapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankController {
    private BankView view;
    // private Bank model;

    public BankController(BankView view) {
        this.view = view;
        // model = new Bank();

        this.view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String user = view.getUser();
        try {
            String password = view.getPassword();
            if(password.equals("3")) {
                view.showMessage("Bem-vindo, " + user);
            } else view.showMessage("Senha incorreta");
        } catch (NumberFormatException e) {
            view.showMessage("Senha inválida.");
            return;
        }
    }
}
