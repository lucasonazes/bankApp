// MVC example

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Classe Modelo
class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

// Classe View
class PessoaView extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JButton salvarButton;

    public PessoaView() {
        setTitle("Cadastro de Pessoa");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nomeField = new JTextField(20);
        idadeField = new JTextField(20);
        salvarButton = new JButton("Salvar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Idade:"));
        panel.add(idadeField);
        panel.add(new JLabel(""));
        panel.add(salvarButton);

        add(panel);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public int getIdade() {
        return Integer.parseInt(idadeField.getText());
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

// Classe Controladora
class PessoaController {
    private PessoaView view;
    private Pessoa model;

    public PessoaController(PessoaView view) {
        this.view = view;

        this.view.getSalvarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPessoa();
            }
        });
    }

    private void salvarPessoa() {
        String nome = view.getNome();
        int idade;
        try {
            idade = view.getIdade();
        } catch (NumberFormatException e) {
            view.showMessage("Idade inválida.");
            return;
        }

        model = new Pessoa(nome, idade);
        view.showMessage("Pessoa salva: " + model);
    }
}

// Classe Principal
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PessoaView view = new PessoaView();
                PessoaController controller = new PessoaController(view);
                view.setVisible(true);
            }
        });
    }
}

