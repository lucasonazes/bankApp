package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.models.Session;
import bankapp.views.OperationsView;

public class OperationsController {
    private OperationsView view;
    private Session session = Session.getInstance(null, null);

    public OperationsController() {
        view = new OperationsView();
        view.setVisible(true);

        this.view.getDepositButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
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
                invest();
            }
        });

        this.view.getStatementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statement();
            }
        });
    }

    public void deposit() {
        view.showMessage("Depósito realizado!");
        session.log.info("Depósito realizado");
    }

    public void withdraw() {
        view.showMessage("Saque realizado!");
        session.log.info("Saque realizado");
    }

    public void invest() {
        view.showMessage("Investimento realizado!");
        session.log.info("Investimento realizado");
    }

    public void statement() {
        view.showMessage("Aqui está seu extrato");
        session.log.info("Extrato exibido");
    }
}
