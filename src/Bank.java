import javax.swing.*;

public class Bank {
    private JFrame frame = new JFrame();
    private JButton withdraw = new JButton("Withdraw");
    private JButton deposit = new JButton("Deposit");
    private JButton accountHistory = new JButton("Account History");
    private JButton exist = new JButton("Withdraw");
    Bank(){
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
