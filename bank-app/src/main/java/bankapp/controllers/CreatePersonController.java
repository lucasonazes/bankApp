package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.database.Database;
import bankapp.models.Customer;
import bankapp.models.Employee;
import bankapp.models.Manager;
import bankapp.models.Session;
import bankapp.views.CreatePersonView;

public class CreatePersonController {
    private CreatePersonView view;
    private Session session = Session.getInstance(null, null);
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

        if(session.verifyCpf(cpf)) {
            view.showMessage("Usuário já cadastrado");
            return;
        }

        if(role.equals("manager")) {
            Manager manager = new Manager(name, cpf);
            session.bank.addPerson(manager);
            database.addPerson(name, cpf, role);
        } else if (role.equals("employee")) {
            Employee employee = new Employee(name, cpf);
            session.bank.addPerson(employee);
            database.addPerson(name, cpf, role);
        } else if (role.equals("customer")) {
            Customer customer = new Customer(name, cpf);
            session.bank.addPerson(customer);
            database.addPerson(name, cpf, role);
        }

        view.showMessage("Usuário Cadastrado!");
    }
}
