package bankapp.views;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import bankapp.models.Session;

public class CreatePersonView extends JFrame{
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField name;
    private JComboBox<String>  role;
    private JTextField cpf;
    private JButton createPersonButton;
    private Session session = Session.getInstance(null, null);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public CreatePersonView() {
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

        ArrayList<String> fields = new ArrayList<>();
        if(session.account.getOwnerRole().equals("manager")) {
            fields.add("funcionario");
            fields.add("cliente");
        } else if(session.account.getOwnerRole().equals("employee")) {
            fields.add("cliente");
        } else {
            fields.add("gerente");
            fields.add("funcionario");
            fields.add("cliente");
        }

        String[] fieldsArray = new String[fields.size()];
        fieldsArray = fields.toArray(fieldsArray);

        role = new JComboBox(fieldsArray);
        panel.add(role, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        createPersonButton = new JButton("CADASTRAR");
        panel.add(createPersonButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
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
        String ptRole = this.role.getSelectedItem().toString();
        
        if (ptRole == "gerente") {
            ptRole = "manager";
        } else if (ptRole == "funcionario") {
            ptRole = "employee";
        } else if (ptRole == "cliente") {
            ptRole = "customer";
        }

        return ptRole;
    }

    public JButton getCreatePersonButton() {
        return this.createPersonButton;
    }
}
