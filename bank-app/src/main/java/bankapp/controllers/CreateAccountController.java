package bankapp.controllers;

import bankapp.views.CreateAccountView;
import bankapp.views.SetAccountTypeView;

public class CreateAccountController {
    private SetAccountTypeView setAccountTypeView;
    private CreateAccountView createAccountView;

    public CreateAccountController() {
        setAccountTypeView = new SetAccountTypeView();
        setAccountTypeView.setVisible(true);
    }
}
