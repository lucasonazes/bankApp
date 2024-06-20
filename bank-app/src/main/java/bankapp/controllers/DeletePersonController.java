package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import bankapp.views.DeletePersonView;
import bankapp.database.Database;

public class DeletePersonController {
    private DeletePersonView view;
    private Database database = new Database();

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
        
        database.deletePerson(cpf);
        view.showMessage("Usuário excluído com sucesso!");
        view.dispose();
    }
}
