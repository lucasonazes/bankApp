package bankapp;

import javax.swing.*;
import java.awt.*;

/**
 * A classe BankView cria a interface gráfica para gerenciar uma conta bancária.
 */
public class BankView extends JFrame {
    private JPanel panel;
    private GridBagConstraints gbc;
    private JTextField user;
    private JTextField password;
    private JButton loginButton;

    /**
     * Construtor que inicializa a interface gráfica
     */
    public BankView() {
        initComponents();
        login(); // Inicializa os componentes de login
    }

    /**
     * Método para inicializar os componentes da interface gráfica.
     */
    private void initComponents() {
        setTitle("Gerenciador de Contas Bancárias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFont(new Font("System", Font.PLAIN, 14));
        this.panel = new JPanel(new GridBagLayout());
        this.gbc = new GridBagConstraints();
    }

    /**
     * Tela de Login
     */
    private void login() {
        setSize(600, 300);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("REALIZAR LOGIN"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("USUÁRIO:"), gbc);

        gbc.gridx = 2;
        user = new JTextField(5);
        panel.add(user, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("SENHA:"), gbc);

        gbc.gridx = 2;
        password = new JTextField(5);
        panel.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        loginButton = new JButton("ENTRAR");
        panel.add(loginButton, gbc);

        add(panel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public String getUser() {
        return this.user.getText();
    }

    public String getPassword() {
        return this.password.getText();
    }
}