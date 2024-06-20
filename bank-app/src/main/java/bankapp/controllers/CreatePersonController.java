package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.views.CreatePersonView;

public class CreatePersonController {
    private CreatePersonView view;
    private Database database = new Database();

    public CreatePersonController() {
        view = new CreatePersonView();
        view.setVisible(true);

        this.view.getCreatePersonButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createPerson();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void createPerson() throws SQLException {
        String name = view.getName();
        String cpf = view.getCpf();
        String role = view.getRole();

        database.addPerson(name, cpf, role);
        view.showMessage("Usuário Cadastrado!");
    }
}
