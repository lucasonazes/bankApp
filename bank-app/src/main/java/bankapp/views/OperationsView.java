package bankapp.views;

import javax.swing.*;

import bankapp.models.Session;

import java.awt.*;

public class OperationsView extends JFrame{

    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField value;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton statementButton;
    private JButton investButton;
    private Session session = Session.getInstance(null, null);

    public OperationsView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 400);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        JLabel jlabel = new JLabel("GERENCIAR CONTA");
        jlabel.setFont(new Font("System", Font.PLAIN, 24));
        panel.add(jlabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        String accountNumber = String.valueOf(session.account.getAccountNumber());
        panel.add(new JLabel("NÚMERO DA CONTA: "+accountNumber), gbc);

        gbc.gridy = 2;
        panel.add(new JLabel("NOME DO PROPRETÁRIO: "+session.account.getOwnerName()), gbc);

        gbc.gridy = 3;
        panel.add(new JLabel("VALOR PRÉ-RENDIMENTO: "+session.account.getBalance()), gbc);

        gbc.gridy = 4;
        panel.add(new JLabel("RENDIMENTO TOTAL: "+session.account.getBalance()), gbc);

        gbc.gridy = 5;
        panel.add(new JLabel("CBD: "+session.account.getBalance()), gbc);

        gbc.gridy = 6;
        panel.add(new JLabel("SALDO: "+session.account.getBalance()), gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("VALOR:"), gbc);

        gbc.gridx = 2;
        value = new JTextField(10);
        panel.add(value, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        depositButton = new JButton("DEPÓSITO");
        panel.add(depositButton, gbc);

        gbc.gridx = 1;
        withdrawButton = new JButton("SAQUE");
        panel.add(withdrawButton, gbc);

        gbc.gridx = 2;
        investButton = new JButton("INVESTIMENTO");
        panel.add(investButton, gbc);

        gbc.gridy = 9;
        gbc.gridx = 1;
        statementButton = new JButton("EXTRATO");
        panel.add(statementButton, gbc);

        add(panel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public double getValue() {
        String stringValue = this.value.getText();
        double finalValue = Double.parseDouble(stringValue);
        System.out.println(finalValue);
        return finalValue;
    }
    
    public JButton getDepositButton() {
        return this.depositButton;
    }

    public JButton getWithdrawButton() {
        return this.withdrawButton;
    }

    public JButton getStatementButton() {
        return this.statementButton;
    }

    public JButton getInvestButton() {
        return this.investButton;
    }
}
