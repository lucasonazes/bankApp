package bankapp.views;

import javax.swing.*;

import bankapp.models.CurrentAccount;
import bankapp.models.Session;

import java.awt.*;

public class OperationsView extends JFrame{

    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField value;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton statementButton;
    private JButton investButton = new JButton("INVESTIMENTO");
    private JButton incomeButton = new JButton("RENDIMENTO");
    private JLabel totalIncomeLabel;
    private JLabel cdbLabel;
    private JLabel balanceLabel;
    private Session session = Session.getInstance(null, null);

    public OperationsView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 500);

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

        // Se a conta for corrente
        if (session.account instanceof CurrentAccount) {
            
            // Casting de Account para CurrentAccount
            CurrentAccount currentAccount = (CurrentAccount) session.account;
            double cdb = currentAccount.getCdb();
            double totalIncome = currentAccount.getTotalIncome();

            gbc.gridy = 3;
            totalIncomeLabel = new JLabel("RENDIMENTO TOTAL: R$ "+String.format("%.2f",totalIncome));
            panel.add(totalIncomeLabel, gbc);

            gbc.gridy = 4;
            cdbLabel = new JLabel("CBD: R$ "+String.format("%.2f",cdb));
            panel.add(cdbLabel, gbc);
        }

        gbc.gridy = 5;
        balanceLabel = new JLabel("SALDO: R$ "+session.account.getBalance());
        panel.add(balanceLabel, gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("VALOR:"), gbc);

        gbc.gridx = 2;
        value = new JTextField(10);
        panel.add(value, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        depositButton = new JButton("DEPÓSITO");
        panel.add(depositButton, gbc);

        gbc.gridx = 1;
        withdrawButton = new JButton("SAQUE");
        panel.add(withdrawButton, gbc);
        
        gbc.gridx = 2;
        statementButton = new JButton("EXTRATO");
        panel.add(statementButton, gbc);

        if (session.account instanceof CurrentAccount) {
            gbc.gridy = 8;
            gbc.gridx = 0;
            panel.add(investButton, gbc);

            gbc.gridx = 2;
            panel.add(incomeButton, gbc);
        }

        add(panel);
        setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void updateFields() {
        balanceLabel.setText("SALDO: R$ " + session.account.getBalance());
        value.setText("");

        if(session.account instanceof CurrentAccount) {
            CurrentAccount currentAccount = (CurrentAccount) session.account;

            totalIncomeLabel.setText("RENDIMENTO TOTAL: R$ " + String.format("%.2f",currentAccount.getTotalIncome()));
            cdbLabel.setText("CDB: R$ " + String.format("%.2f",currentAccount.getCdb()));
        }
    }

    public double getValue() {
        String stringValue = this.value.getText();
        double finalValue = Double.parseDouble(stringValue);
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

    public JButton getIncomeButton() {
        return this.incomeButton;
    }
}
