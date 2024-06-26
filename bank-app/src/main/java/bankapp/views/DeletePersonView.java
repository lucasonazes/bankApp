package bankapp.views;

import java.awt.*;
import javax.swing.*;

public class DeletePersonView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField cpf;
    private JButton deletePersonButton;

    public DeletePersonView() {
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
        panel.add(new JLabel("EXCLUIR USUÁRIO"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("CPF USUÁRIO:"), gbc);

        gbc.gridx = 2;
        cpf = new JTextField(10);
        panel.add(cpf, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        deletePersonButton = new JButton("EXCLUIR");
        panel.add(deletePersonButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public String getCpf() {
        return this.cpf.getText();
    }

    public JButton getDeletePersonButton() {
        return this.deletePersonButton;
    }
}
