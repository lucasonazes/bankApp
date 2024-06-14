package bankapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A classe front cria a interface gráfica para gerenciar uma conta bancária.
 */
public class Front extends JFrame {
    private JTextField amountField; // Campo de texto para inserir valores de depósito/saque
    private JLabel balanceLabel; // Rótulo para exibir o saldo atual

    /**
     * Construtor que inicializa a interface gráfica
     */
    public Front() {
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
        // depositButton.addActionListener(new DepositAction()); // Define a ação do botão
        panel.add(depositButton, gbc);

        // Adiciona um botão de saque
        gbc.gridx = 1; // Coluna 1
        JButton withdrawButton = new JButton("Sacar");
        // withdrawButton.addActionListener(new WithdrawAction()); // Define a ação do botão
        panel.add(withdrawButton, gbc);

        // Adiciona um JLabel para exibir o saldo
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 2; // O JLabel ocupa duas colunas
        balanceLabel = new JLabel("Saldo: R$ ");
        panel.add(balanceLabel, gbc);

        add(panel); // Adiciona o painel à janela
    }
}