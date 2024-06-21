package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.models.Customer;
import bankapp.models.Employee;
import bankapp.models.Manager;
import bankapp.views.CreatePersonView;

public class CreatePersonController {
    private CreatePersonView view;

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

        if(role.equals("gerente")) {
            new Manager(name, cpf);
        } else if (role.equals("funcionario")) {
            new Employee(name, cpf);
        } else if (role.equals("cliente")) {
            new Customer(name, cpf);
        }

        view.showMessage("Usuário Cadastrado!");
    }
}
