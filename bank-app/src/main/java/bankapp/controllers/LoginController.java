package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.Account;
import bankapp.models.Bank;
import bankapp.models.Session;
import bankapp.views.LoginView;

public class LoginController {
    private LoginView view;
    private Database database = new Database();

    public LoginController() {
        view = new LoginView();
        view.setVisible(true);

        this.view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    login();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void login() throws SQLException {
        Session.getInstance(null, null).clear();
        String user = view.getUser();
        String password = view.getPassword();

        Account account = database.auth(user, password);

        if (account != null) {
            Bank bank = new Bank();
            Session session = Session.getInstance(account, bank);
            System.out.println("Nova sessão iniciada | Número da conta logada: "+session.account.getAccountNumber());
            view.showMessage("Bem vindo, "+user);
            session.log.info("Usuário "+session.account.getUser()+" realizou login");
            new ManageAccountController();
        } else {
            view.showMessage("Senha ou usuário incorretos!");
            return;
        }
    }
}
