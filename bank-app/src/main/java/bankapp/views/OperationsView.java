package bankapp.views;

import javax.swing.*;
import java.awt.*;

public class OperationsView extends JFrame{

    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField value;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton statementButton;

    public OperationsView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 300);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("GERENCIAR CONTA"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("VALOR:"), gbc);

        gbc.gridx = 2;
        value = new JTextField(10);
        panel.add(value, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        depositButton = new JButton("DEPÓSITO");
        panel.add(depositButton, gbc);

        gbc.gridx = 1;
        withdrawButton = new JButton("SAQUE");
        panel.add(withdrawButton, gbc);

        gbc.gridx = 2;
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
}
