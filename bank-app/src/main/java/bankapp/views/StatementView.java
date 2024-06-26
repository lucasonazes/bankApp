package bankapp.views;

import javax.swing.*;

import bankapp.database.Database;
import bankapp.models.Operation;
import bankapp.models.Session;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatementView extends JFrame{
    private JTextArea textArea = new JTextArea();
    private Session session = Session.getInstance(null, null);
    private Database database = new Database();

    public StatementView() throws SQLException {
        setTitle("Santander");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFont(new Font("System", Font.PLAIN, 14));

        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        StringBuilder sb = new StringBuilder();

        ArrayList<Operation> operations = database.getOperations(session.account.getAccountNumber());
        session.account.setOperations(operations);

        String title = "EXTRATO DA CONTA "+session.account.getAccountNumber();
        sb.append(title).append("\n");

        for (Operation operation : operations) {
            if (operation.getType().equals("investment")) {

                String line = "Investimento no valor de "+operation.getValue()+" realizado em "+operation.getTimestamp();
                sb.append(line).append("\n");

            } else if (operation.getType().equals("deposit")) {

                String line = "Depósito no valor de "+operation.getValue()+" realizado em "+operation.getTimestamp();
                sb.append(line).append("\n");

            } else if (operation.getType().equals("withdraw")) {

                String line = "Saque no valor de "+operation.getValue()+" realizado em "+operation.getTimestamp();
                sb.append(line).append("\n");

            } else {
                String line = "Operação não identificada no valor de "+operation.getValue()+" realizada em "+operation.getTimestamp();
                sb.append(line).append("\n");
            }

            String line ="__________________________________________________";
            sb.append(line).append("\n");
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
