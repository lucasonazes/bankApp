import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Alisson {
    private static final Banco banco = new Banco();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gerenciador de Contas Bancárias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.CENTER;

        frame.getContentPane().add(panel);


        JButton createButton = new JButton("Criar Conta");
        JButton deleteButton = new JButton("Excluir Conta");
        JButton manageButton = new JButton("Gerenciar Conta");
        JButton listButton = new JButton("Listar Contas");
        JButton exitButton = new JButton("Sair");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(createButton, gbc);
        gbc.gridy = 1;
        panel.add(deleteButton, gbc);
        gbc.gridy = 2;
        panel.add(manageButton, gbc);
        gbc.gridy = 3;
        panel.add(listButton, gbc);
        gbc.gridy = 4;
        panel.add(exitButton, gbc);

        


        frame.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcoes = {"Conta Corrente", "Conta Poupança"};
                int tipoConta = JOptionPane.showOptionDialog(frame, "Selecione o tipo de conta:",
                        "Tipo de Conta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, opcoes, opcoes[0]);

                if (tipoConta == JOptionPane.CLOSED_OPTION) {
                    return;
                }

                String nome = JOptionPane.showInputDialog(frame, "Digite o nome do usuário:");
                String rg = JOptionPane.showInputDialog(frame, "Digite o RG do usuário:");
                String cpf = JOptionPane.showInputDialog(frame, "Digite o CPF do usuário:");

                Usuario usuario = new Usuario(nome, rg, cpf);
                ContaBancaria conta;

                if (tipoConta == 0) {
                    conta = new ContaCorrente(usuario);
                } else {
                    conta = new ContaPoupanca(usuario);
                }

                banco.adicionarConta(conta);

                JOptionPane.showMessageDialog(frame, "Conta " + (tipoConta == 0 ? "Corrente" : "Poupança") + " adicionada com sucesso!\n" +
                        "Número da Conta: " + conta.getNumeroConta() + "\n" +
                        "Tipo: " + (tipoConta == 0 ? "Conta Corrente" : "Conta Poupança") + "\n" +
                        "Data de Criação: " + new Date() + "\n" +
                        "Nome do Usuário: " + usuario.getNome() + "\n" +
                        "RG do Usuário: " + usuario.getRg() + "\n" +
                        "CPF do Usuário: " + usuario.getCpf());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroContaStr = JOptionPane.showInputDialog(frame, "Digite o número da conta a ser excluída:");
                try {
                    int numeroConta = Integer.parseInt(numeroContaStr);
                    banco.excluirConta(numeroConta);
                    JOptionPane.showMessageDialog(frame, "Conta excluída com sucesso.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número de conta inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroContaStr = JOptionPane.showInputDialog(frame, "Digite o número da conta a ser gerenciada:");
                try {
                    int numeroConta = Integer.parseInt(numeroContaStr);
                    ContaBancaria conta = banco.gerenciarConta(numeroConta);
                    if (conta != null) {
                        JFrame manageFrame = new JFrame("Gerenciar Conta");
                        
                        manageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        manageFrame.setSize(300, 200);
                        JPanel managePanel = new JPanel();
                        manageFrame.getContentPane().add(managePanel);

                        JButton depositButton = new JButton("Depositar");
                        JButton withdrawButton = new JButton("Sacar");
                        JButton statementButton = new JButton("Extrato");
                        
                        gbc.gridx = 0;
                        gbc.gridy = 1;
                        panel.add(depositButton, gbc);

                        managePanel.add(depositButton);
                        managePanel.add(withdrawButton);
                        managePanel.add(statementButton);

                        depositButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String valorStr = JOptionPane.showInputDialog(manageFrame, "Digite o valor para depósito:");
                                try {
                                    double valor = Double.parseDouble(valorStr);
                                    conta.depositar(valor);
                                    JOptionPane.showMessageDialog(manageFrame, "Depósito realizado com sucesso.\nSaldo atual: R$" + conta.getSaldo());
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(manageFrame, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                        withdrawButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String valorStr = JOptionPane.showInputDialog(manageFrame, "Digite o valor para saque:");
                                try {
                                    double valor = Double.parseDouble(valorStr);
                                    if (valor > conta.getSaldo()) {
                                        JOptionPane.showMessageDialog(manageFrame, "Saldo insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        conta.sacar(valor);
                                        JOptionPane.showMessageDialog(manageFrame, "Saque realizado com sucesso.\nSaldo atual: R$" + conta.getSaldo());
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(manageFrame, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                        statementButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                StringBuilder extrato = new StringBuilder("Extrato da Conta:\n\n");
                                for (String transacao : conta.getTransacoes()) {
                                    extrato.append(transacao).append("\n");
                                }
                                JOptionPane.showMessageDialog(manageFrame, extrato.toString());
                            }
                        });

                        manageFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Conta não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número de conta inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("Lista de Contas:\n\n");

                for (ContaBancaria conta : banco.getContas()) {
                    mensagem.append("Número da Conta: ").append(conta.getNumeroConta()).append("\n");
                    mensagem.append("Tipo: ").append(conta instanceof ContaPoupanca ? "Conta Poupança" : "Conta Corrente").append("\n");
                    mensagem.append("Data de Criação: ").append(new Date()).append("\n");
                    mensagem.append("Nome do Usuário: ").append(conta.getUsuario().getNome()).append("\n");
                    mensagem.append("RG do Usuário: ").append(conta.getUsuario().getRg()).append("\n");
                    mensagem.append("CPF do Usuário: ").append(conta.getUsuario().getCpf()).append("\n");
                    mensagem.append("Saldo: R$").append(conta.getSaldo()).append("\n");
                    mensagem.append("\n");
                }

                if (mensagem.toString().equals("Lista de Contas:\n\n")) {
                    mensagem.append("Nenhuma conta cadastrada.");
                }

                JOptionPane.showMessageDialog(frame, mensagem.toString());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}