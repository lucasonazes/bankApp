package bankapp.views;

import java.awt.*;
import javax.swing.*;

public class SetAccountTypeView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JButton currentAccountButton;
    private JButton savingsAccountButton;

    public SetAccountTypeView() {
        setTitle("Criar Conta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 300);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        currentAccountButton = new JButton("CONTA CORRENTE");
        panel.add(currentAccountButton, gbc);

        gbc.gridx = 1;
        savingsAccountButton = new JButton("CONTA POUPANÇA");
        panel.add(savingsAccountButton, gbc);

        add(panel);
    }

    public JButton getCurrentAccountButton() {
        return this.currentAccountButton;
    }

    public JButton getSavingsAccountButton() {
        return this.savingsAccountButton;
    }
}
