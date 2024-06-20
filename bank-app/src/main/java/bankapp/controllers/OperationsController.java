package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.views.OperationsView;

public class OperationsController {
    private OperationsView view;

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

        this.view.getStatementButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statement();
            }
        });
    }

    public void deposit() {
        view.showMessage("Depósito realizado!");
    }

    public void withdraw() {
        view.showMessage("Saque realizado!");
    }

    public void statement() {
        view.showMessage("Aqui está seu extrato");
    }
}
