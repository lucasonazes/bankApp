package bankapp.views;

import javax.swing.*;

import bankapp.models.Account;
import bankapp.models.Session;

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
    private Session session = Session.getInstance(null, null);
    private Account account = session.getAccount();

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

        String text = "Bem vindo, " + account.getOwnerName();

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("System", Font.PLAIN, 24));
        panel.add(jlabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        createButton = new JButton("CRIAR CONTA");
        if (account.getOwnerRole().equals("manager") || account.getOwnerRole().equals("admin")) 
        panel.add(createButton, gbc);

        gbc.gridy = 2;
        manageButton = new JButton("GERENCIAR CONTA");
        if (account.getOwnerRole().equals("customer"))
        panel.add(manageButton, gbc);

        gbc.gridy = 3;
        createPerson = new JButton("CADASTRAR USUÁRIO");
        if (account.getOwnerRole().equals("manager") || account.getOwnerRole().equals("admin"))
        panel.add(createPerson, gbc);

        gbc.gridy = 4;
        deletePerson = new JButton("EXCLUIR USUÁRIO");
        if (account.getOwnerRole().equals("manager") || account.getOwnerRole().equals("admin"))
        panel.add(deletePerson, gbc);

        gbc.gridy = 5;
        deleteButton = new JButton("EXCLUIR CONTA");
        if (account.getOwnerRole().equals("manager") || account.getOwnerRole().equals("admin"))
        panel.add(deleteButton, gbc);

        gbc.gridy = 6;
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
