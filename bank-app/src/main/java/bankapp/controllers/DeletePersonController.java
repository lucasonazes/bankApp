package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.views.DeletePersonView;
import bankapp.database.Database;
import bankapp.models.Person;
import bankapp.models.Session;

public class DeletePersonController {
    private DeletePersonView view;
    private Database database = new Database();
    private Session session = Session.getInstance(null, null);

    public DeletePersonController() {
        view = new DeletePersonView();
        view.setVisible(true);

        this.view.getDeletePersonButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deletePerson();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void deletePerson() throws SQLException {
        String cpf = view.getCpf();
        
        Person person = session.bank.getPerson(cpf);
        session.bank.deletePerson(person);
        database.deletePerson(cpf);
        view.showMessage("Usuário excluído com sucesso!");
        session.log.info("Usuário de cpf "+person.getCpf()+" excluído por "+session.account.getUser());
        view.dispose();
    }
}
