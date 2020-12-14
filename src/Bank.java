import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank extends BankAccount implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton withdraw = new JButton("Withdraw");
    private JButton deposit = new JButton("Deposit");
    private JButton balance = new JButton("Balance");
    private JButton exit = new JButton("Exit");
    private JLabel welcome = new JLabel("Welcome");
    private JLabel userId = new JLabel();

    private User user;

    Bank(User user){

        this.user = user;
        withdraw.setBounds(250,60,100,50);
        deposit.setBounds(250,120,100,50);
        balance.setBounds(250,180,100,50);
        exit.setBounds(250,240,100,50);
        welcome.setBounds(50,80,150,100);
        userId.setBounds(90, 120, 100, 100);
        userId.setFont(new Font(null, Font.ITALIC,24));
        welcome.setFont(new Font(null, Font.BOLD,30));


        userId.setText(user.getUserId());

        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        balance.addActionListener(this);
        exit.addActionListener(this);


        frame.add(withdraw);
        frame.add(deposit);
        frame.add(balance);
        frame.add(exit);
        frame.add(userId);
        frame.add(welcome);


        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw){
            frame.setVisible(false);
            Withdraw withdraw = new Withdraw(this.user);
        }
        if(e.getSource() == deposit){
            frame.setVisible(false);
            Deposit deposit= new Deposit(this.user);
        }
        if(e.getSource() == balance){
            frame.setVisible(false);
            Balance balance = new Balance(this.user);
        }
        if(e.getSource() == exit){
            frame.setVisible(false);
            BankAccount loginPage = new LoginPage("src/AccountInfo");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new User("alex", 0,0));
    }

}
