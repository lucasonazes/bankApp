package bankapp.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bankapp.views.CreatePersonView;

public class CreatePersonController {
    private CreatePersonView view;

    public CreatePersonController() {
        view = new CreatePersonView();
        view.setVisible(true);

        this.view.getCreatePersonButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPerson();
            }
        });
    }

    public void createPerson() {
        view.showMessage("Usuário Cadastrado!");
    }
}
