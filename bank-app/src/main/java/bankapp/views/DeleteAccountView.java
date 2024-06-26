package bankapp.views;

import java.awt.*;
import javax.swing.*;

public class DeleteAccountView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField accountNumber;
    private JButton deleteAccountButton;

    public DeleteAccountView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 300);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("EXCLUIR CONTA"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("NÚMERO DA CONTA:"), gbc);

        gbc.gridx = 2;
        accountNumber = new JTextField(10);
        panel.add(accountNumber, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        deleteAccountButton = new JButton("EXCLUIR");
        panel.add(deleteAccountButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public int getAccountNumber() {
        String accountNumberString = this.accountNumber.getText();
        int accountNumberFinal = Integer.parseInt(accountNumberString);
        return accountNumberFinal;
    }

    public JButton getDeleteAccountButton() {
        return this.deleteAccountButton;
    }
}
