package bankapp.views;

import javax.swing.*;

import bankapp.models.Session;
import bankapp.models.Account;
import bankapp.models.CurrentAccount;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAccountsView extends JFrame{
    private JTextArea textArea = new JTextArea();
    private Session session = Session.getInstance(null, null);

    public ShowAccountsView() throws SQLException {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFont(new Font("System", Font.PLAIN, 14));

        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        StringBuilder sb = new StringBuilder();

        ArrayList<Account> accounts = session.bank.getAccounts();

        String title = "CONTAS ATIVAS";
        sb.append(title).append("\n");

        for (Account account : accounts) {
            String line ="__________________________________________________";
            sb.append(line).append("\n");

            if (account.getType().equals("current")) {
                CurrentAccount currentAccount = (CurrentAccount) account;

                line = "Número da conta: "+currentAccount.getAccountNumber();
                sb.append(line).append("\n");

                line = "Usuário: "+currentAccount.getUser();
                sb.append(line).append("\n");

                line = "Nome do proprietário: "+currentAccount.getOwnerName();
                sb.append(line).append("\n");

                line = "CPF do proprietário: "+currentAccount.getOwnerCpf();
                sb.append(line).append("\n");

                line = "CDB: "+String.format("%.2f",currentAccount.getCdb());
                sb.append(line).append("\n");

                line = "Rendimento Total: "+String.format("%.2f",currentAccount.getTotalIncome());

                line = "Saldo: "+currentAccount.getBalance();
                sb.append(line).append("\n");

            } else {

                line = "Número da conta: "+account.getAccountNumber();
                sb.append(line).append("\n");

                line = "Usuário: "+account.getUser();
                sb.append(line).append("\n");

                line = "Nome do proprietário: "+account.getOwnerName();
                sb.append(line).append("\n");

                line = "CPF do proprietário: "+account.getOwnerCpf();
                sb.append(line).append("\n");

                line = "Saldo: "+account.getBalance();
                sb.append(line).append("\n");

            }
        }

        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 300));
        setVisible(true);
    }
}
