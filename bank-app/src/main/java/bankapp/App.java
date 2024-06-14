package bankapp;

import javax.swing.SwingUtilities;

public class App 
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Front front = new Front();
                // BankController controller = new BankController(front);
                front.setVisible(true);
            }
        });
    }
}
