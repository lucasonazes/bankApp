package bankapp;

import javax.swing.SwingUtilities;

public class App 
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @SuppressWarnings("unused")
            @Override
            public void run() {
                BankView front = new BankView();
                BankController controller = new BankController(front);
                front.setVisible(true);
            }
        });
    }
}
