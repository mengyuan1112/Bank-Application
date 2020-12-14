import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton savingAccount = new JButton("Saving Account");
    private JButton checkingAccount = new JButton("Checking Account");
    private JButton exit = new JButton("Exit");
    private JLabel name = new JLabel();
    private JLabel title = new JLabel("Deposit");

    private User user;
    private BankAccount bankAccount;

    Deposit(User user){
        this.user = user;
        this.bankAccount = bankAccount;
        name.setText(user.getUserId());

        savingAccount.setBounds(10,150, 170, 50);
        checkingAccount.setBounds(210,150, 170, 50);
        exit.setBounds(140, 270,100,50);
        name.setBounds(165, 70,100,50);
        title.setBounds(145, 30,200,50);

        title.setFont(new Font(null,Font.BOLD,27));
        name.setFont(new Font(null,Font.ITALIC,30));

        savingAccount.addActionListener(this);
        checkingAccount.addActionListener(this);
        exit.addActionListener(this);
        frame.add(exit);
        frame.add(savingAccount);
        frame.add(checkingAccount);
        frame.add(name);
        frame.add(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.checkingAccount){
            CheckingAccount checkingAccount = new CheckingAccount(this.user);
            frame.setVisible(false);
        }
        else if(e.getSource() == this.savingAccount){
            SavingAccount savingAccount = new SavingAccount(this.user);
            frame.setVisible(false);
        }
        else {
            frame.setVisible(false);
            Bank bank = new Bank(this.user);
        }
    }
}
