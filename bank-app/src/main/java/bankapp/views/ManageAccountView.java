package bankapp.views;

import javax.swing.*;
import java.awt.*;

public class ManageAccountView extends JFrame{

    private JPanel panel;
    private GridBagConstraints gbc;
    private JButton createButton;
    private JButton manageButton;
    private JButton createPerson;
    private JButton deletePerson;
    private JButton deleteButton;
    private JButton exitButton;

    public ManageAccountView() {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        setSize(600, 450);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        createButton = new JButton("CRIAR CONTA");
        panel.add(createButton, gbc);

        gbc.gridy = 1;
        manageButton = new JButton("GERENCIAR CONTA");
        panel.add(manageButton, gbc);

        gbc.gridy = 2;
        createPerson = new JButton("CADASTRAR USUÁRIO");
        panel.add(createPerson, gbc);

        gbc.gridy = 3;
        deletePerson = new JButton("EXCLUIR USUÁRIO");
        panel.add(deletePerson, gbc);

        gbc.gridy = 4;
        deleteButton = new JButton("EXCLUIR CONTA");
        panel.add(deleteButton, gbc);

        gbc.gridy = 5;
        exitButton = new JButton("SAIR");
        panel.add(exitButton, gbc);

        add(panel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JButton getCreateButton() {
        return this.createButton;
    }

    public JButton getManageButton() {
        return this.manageButton;
    }

    public JButton getCreatePerson() {
        return this.createPerson;
    }

    public JButton getDeletePerson() {
        return this.deletePerson;
    }

    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    public JButton getExitButton() {
        return this.exitButton;
    }
}
