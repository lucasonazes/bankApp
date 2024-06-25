package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.CurrentAccount;
import bankapp.models.Session;
import bankapp.views.OperationsView;

public class OperationsController {
    private OperationsView view;
    private Session session = Session.getInstance(null, null);
    private Database database = new Database();

    public OperationsController() {
        view = new OperationsView();
        view.setVisible(true);

        this.view.getDepositButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deposit();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.view.getWithdrawButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        this.view.getInvestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    invest();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.view.getStatementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statement();
            }
        });
    }

    public void deposit() throws SQLException {
        double value = view.getValue();

        if(!session.account.deposit(value)) {
            view.showMessage("Valor inválido!");
            return;
        }

        if(session.account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) session.account;
            database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        } else {
            database.setData(session.account.getAccountNumber(), session.account.getBalance(), 0, 0, 0);
        }

        database.addOperation(session.account.getAccountNumber(), "deposit", value);
        view.showMessage("Depósito realizado!");
        session.log.info("Depósito no valor de R$ "+value+" realizado por "+session.account.getUser());
    }

    public void withdraw() {
        view.showMessage("Saque realizado!");
        session.log.info("Saque realizado");
    }

    public void invest() throws SQLException {
        double value = view.getValue();

        CurrentAccount currentAccount = (CurrentAccount) session.account;
        if(!currentAccount.invest(value)) {
            view.showMessage("Valor inválido!");
            return;
        };
        session.account = currentAccount;
        
        database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        database.addOperation(session.account.getAccountNumber(), "investment", value);
        view.showMessage("Investimento realizado!");
        session.log.info("Investimento no valor de R$ "+value+" realizado por "+session.account.getUser());
    }

    public void statement() {
        view.showMessage("Aqui está seu extrato");
        session.log.info("Extrato exibido");
    }
}
