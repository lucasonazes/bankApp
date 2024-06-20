package bankapp.views;

import java.awt.*;
import javax.swing.*;

public class CreatePersonView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField name;
    private JTextField role;
    private JTextField cpf;
    private JButton createPersonButton;

    public CreatePersonView() {
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
        panel.add(new JLabel("CADASTRAR USUÁRIO"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("NOME USUÁRIO:"), gbc);

        gbc.gridx = 2;
        name = new JTextField(10);
        panel.add(name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("CPF USUÁRIO:"), gbc);

        gbc.gridx = 2;
        cpf = new JTextField(10);
        panel.add(cpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("CARGO:"), gbc);

        gbc.gridx = 2;
        role = new JTextField(10);
        panel.add(role, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        createPersonButton = new JButton("CADASTRAR");
        panel.add(createPersonButton, gbc);

        add(panel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getName() {
        return this.name.getText();
    }

    public String getCpf() {
        return this.cpf.getText();
    }

    public String getRole() {
        return this.role.getText();
    }

    public JButton getCreatePersonButton() {
        return this.createPersonButton;
    }
}
