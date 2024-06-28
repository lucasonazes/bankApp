package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.CurrentAccount;
import bankapp.models.Session;
import bankapp.views.OperationsView;
import bankapp.views.StatementView;

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
                try {
                    withdraw();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
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
                try {
                    statement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.view.getIncomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    income();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void deposit() throws SQLException {
        double value = view.getValue();

        int result = session.account.deposit(value);
        
        if(result == 0) {
            System.out.print("Depósito realizado!");
        } else if(result == 1) {
            view.showMessage("O valor deve ser maior que 0!");
            return;
        } else {
            view.showMessage("Valor inválido");
            return;
        }

        if(session.account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) session.account;
            database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        } else {
            database.setData(session.account.getAccountNumber(), session.account.getBalance(), 0, 0, 0);
        }

        database.addOperation(session.account.getAccountNumber(), "deposit", value);
        view.updateFields();
        view.showMessage("Depósito realizado!");
        session.log.info("Depósito no valor de R$ "+value+" realizado por "+session.account.getUser());
    }

    public void withdraw() throws SQLException {
        double value = view.getValue();

        int result = session.account.withdraw(value);

        if(result == 0) {
            System.out.print("Saque realizado!");
        } else if(result == 1) {
            view.showMessage("Saldo insuficiente!");
            return;
        } else if(result == 2) {
            view.showMessage("O valor deve ser maior que 0!");
            return;
        } else {
            view.showMessage("Valor inválido");
            return;
        }

        if(session.account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) session.account;
            database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        } else {
            database.setData(session.account.getAccountNumber(), session.account.getBalance(), 0, 0, 0);
        }

        database.addOperation(session.account.getAccountNumber(), "withdraw", value);
        view.updateFields();
        view.showMessage("Saque realizado!");
        session.log.info("Saque no valor de R$ "+value+" realizado por "+session.account.getUser());
    }

    public void invest() throws SQLException {
        double value = view.getValue();

        CurrentAccount currentAccount = (CurrentAccount) session.account;
        int result = currentAccount.invest(value);

        if(result == 0) {
            System.out.print("Investimento realizado!");
        } else if(result == 1) {
            view.showMessage("Saldo insuficiente!");
            return;
        } else if(result == 2) {
            view.showMessage("O valor deve ser maior que 0!");
            return;
        } else {
            view.showMessage("Valor inválido");
            return;
        }

        session.account = currentAccount;
        
        database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        database.addOperation(session.account.getAccountNumber(), "investment", value);
        view.updateFields();
        view.showMessage("Investimento realizado!");
        session.log.info("Investimento no valor de R$ "+value+" realizado por "+session.account.getUser());
    }

    public void statement() throws SQLException {
        session.log.info("Extrato exibido por "+session.account.getUser());
        new StatementView();
    }

    public void income() throws SQLException {
        int days = (int)view.getValue();

        CurrentAccount currentAccount = (CurrentAccount) session.account;
        double prev = currentAccount.getCdb();
        int result = currentAccount.income(days);

        if(result == 0) {
            System.out.print("Rendimento ocorreu com sucesso!");
        } else if(result == 1) {
            view.showMessage("O valor deve ser maior que 0!");
            return;
        } else {
            view.showMessage("Valor inválido");
            return;
        }

        session.account = currentAccount;
        double income = currentAccount.getCdb() - prev;

        database.setData(session.account.getAccountNumber(), currentAccount.getBalance(), currentAccount.getCdb(), currentAccount.getPrevious(), currentAccount.getTotalIncome());
        view.updateFields();

        if (days < 2) {
            view.showMessage(days+" dia se passou...");
            session.log.info(days+" dia se passou e ocorreu um rendimento de R$ "+String.format("%.2f",income)+" na conta de número "+session.account.getAccountNumber()+" do usuário "+session.account.getUser());
        } else {
            view.showMessage(days+" dias se passaram...");
            session.log.info(days+" dias se passaram e ocorreu um rendimento de R$ "+String.format("%.2f",income)+" na conta de número "+session.account.getAccountNumber()+" do usuário "+session.account.getUser());
        }
    }
}
