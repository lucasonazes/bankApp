package bankapp.views;

import java.awt.*;
import javax.swing.*;

public class CreateAccountView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField user;
    private JTextField password;
    private JTextField ownerName;
    private JTextField ownerCpf;
    private JComboBox<String> ownerRole;
    private JButton createAccountButton;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CreateAccountView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 450);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("CRIAR CONTA"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("NOME USUÁRIO:"), gbc);

        gbc.gridx = 2;
        ownerName = new JTextField(10);
        panel.add(ownerName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("CPF USUÁRIO:"), gbc);

        gbc.gridx = 2;
        ownerCpf = new JTextField(10);
        panel.add(ownerCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("CARGO USUÁRIO:"), gbc);

        gbc.gridx = 2;
        String[] fields = {"gerente", "funcionario", "cliente"};
        ownerRole = new JComboBox(fields);
        panel.add(ownerRole, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("USUÁRIO:"), gbc);

        gbc.gridx = 2;
        user = new JTextField(10);
        panel.add(user, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("SENHA:"), gbc);

        gbc.gridx = 2;
        password = new JTextField(10);
        panel.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        createAccountButton = new JButton("CRIAR CONTA");
        panel.add(createAccountButton, gbc);

        add(panel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getUser() {
        return this.user.getText();
    }

    public String getPassword() {
        return this.password.getText();
    }

    public String getOwnerName() {
        return this.ownerName.getText();
    }
    
    public String getOwnerCpf() {
        return this.ownerCpf.getText();
    }

    public String getOwnerRole() {
        return this.ownerRole.getSelectedItem().toString();
    }

    public JButton getCreateAccountButton() {
        return this.createAccountButton;
    }
}