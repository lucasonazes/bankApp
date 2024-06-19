package bankapp;

import javax.swing.SwingUtilities;

import bankapp.controllers.BankController;
import bankapp.views.*;

public class App 
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                LoginView front = new LoginView();
                BankController controller = new BankController(front);
                front.setVisible(true);
            }
        });
    }
}
