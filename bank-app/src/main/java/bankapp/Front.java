package bankapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe front cria a interface gráfica para gerenciar uma conta bancária.
 */
public class Front extends JFrame {
    private Bank bank; // Banco gerenciado pela aplicação
    private JTextField amountField; // Campo de texto para inserir valores de depósito/saque
    private JLabel balanceLabel; // Rótulo para exibir o saldo atual

    /**
     * Construtor que inicializa a interface gráfica e a conta bancária.
     */
    public Front() {
        bank = new Bank(); // Cria uma conta com saldo inicial de 1000.00
        initComponents(); // Inicializa os componentes da interface gráfica
    }

    /**
     * Método para inicializar os componentes da interface gráfica.
     */
    private void initComponents() {
        setTitle("Gerenciador de Contas Bancárias"); // Define o título da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechar a janela
        setSize(400, 200); // Define o tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Cria um painel com layout GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Define espaçamento entre componentes
        gbc.anchor = GridBagConstraints.WEST; // Define o alinhamento dos componentes para a esquerda

        // Adiciona um JLabel e um JTextField para inserir valores
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        panel.add(new JLabel("Valor:"), gbc);

        gbc.gridx = 1; // Coluna 1
        amountField = new JTextField(5); // Campo de texto com 15 colunas
        panel.add(amountField, gbc);

        // Adiciona um botão de depósito
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        JButton depositButton = new JButton("Depositar");
        depositButton.addActionListener(new DepositAction()); // Define a ação do botão
        panel.add(depositButton, gbc);

        // Adiciona um botão de saque
        gbc.gridx = 1; // Coluna 1
        JButton withdrawButton = new JButton("Sacar");
        withdrawButton.addActionListener(new WithdrawAction()); // Define a ação do botão
        panel.add(withdrawButton, gbc);

        // Adiciona um JLabel para exibir o saldo
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 2; // O JLabel ocupa duas colunas
        balanceLabel = new JLabel("Saldo: R$ " + account.getBalance());
        panel.add(balanceLabel, gbc);

        add(panel); // Adiciona o painel à janela
    }

    /**
     * Classe interna para lidar com a ação de depósito.
     */
    private class DepositAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtém o valor digitado no campo de texto
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount); // Realiza o depósito
                updateBalance(); // Atualiza o saldo exibido
            } catch (NumberFormatException ex) {
                // Exibe uma mensagem de erro se o valor for inválido
                JOptionPane.showMessageDialog(BankApp.this, "Por favor, insira um valor válido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Classe interna para lidar com a ação de saque.
     */
    private class WithdrawAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtém o valor digitado no campo de texto
                double amount = Double.parseDouble(amountField.getText());
                if (account.withdraw(amount)) {
                    updateBalance(); // Atualiza o saldo exibido se o saque foi bem-sucedido
                } else {
                    // Exibe uma mensagem de erro se o saldo for insuficiente ou o valor inválido
                    JOptionPane.showMessageDialog(BankApp.this, "Saldo insuficiente ou valor inválido.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                // Exibe uma mensagem de erro se o valor for inválido
                JOptionPane.showMessageDialog(BankApp.this, "Por favor, insira um valor válido.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Atualiza o saldo exibido na interface gráfica.
     */
    private void updateBalance() {
        balanceLabel.setText("Saldo: R$ " + account.getBalance());
        amountField.setText(""); // Limpa o campo de texto
    }

    /**
     * Método principal para iniciar a aplicação.
     * 
     * @param args argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankApp().setVisible(true); // Cria e exibe a janela principal
        });
    }
}