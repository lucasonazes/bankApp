package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.CurrentAccount;
import bankapp.models.Person;
import bankapp.models.SavingsAccount;
import bankapp.views.CreateAccountView;
import bankapp.views.SetAccountTypeView;
import bankapp.models.Session;

public class CreateAccountController {
    private SetAccountTypeView setAccountTypeView;
    private CreateAccountView createAccountView = new CreateAccountView();
    private String type = null;
    private Database database = new Database();
    private Session session = Session.getInstance(null, null);

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
        String ownerCpf = createAccountView.getOwnerCpf();

        if(!session.verifyCpf(ownerCpf)) {
            createAccountView.showMessage("Usuário não existe!");
            return;
        }
        if (session.verifyUser(user)) {
            createAccountView.showMessage("Nome de usuário já utilizado!");
            return;
        }

        Person person = session.getPerson(ownerCpf);

        if (type == "current") {

            session.bank.addAccount(new CurrentAccount(accountNumber, user, password, person.getName(), ownerCpf, person.getRole(), 0, 0, 0, 0));
            database.addAccount(user, password, person.getName(), ownerCpf, person.getRole(), 0, type, 0, 0, 0);

            createAccountView.showMessage("Conta corrente criada com sucesso!");
            session.log.info("Conta corrente criada por "+session.account.getUser());
            createAccountView.dispose();
        } else if (type == "savings") {

            session.bank.addAccount(new SavingsAccount(accountNumber, user, password, person.getName(), ownerCpf, person.getRole(), 0));
            database.addAccount(user, password, person.getName(), ownerCpf, person.getRole(), 0, type, 0, 0, 0);

            createAccountView.showMessage("Conta poupança criada com sucesso!");
            session.log.info("Conta poupança criada por "+session.account.getUser());
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
