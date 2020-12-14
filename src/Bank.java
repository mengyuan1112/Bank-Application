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
    private JLabel userId = new JLabel(super.getUser().getUserId());

    public User user = super.getUser();

    Bank(){

        withdraw.setBounds(250,60,100,50);
        deposit.setBounds(250,120,100,50);
        balance.setBounds(250,180,100,50);
        exit.setBounds(250,240,100,50);
        welcome.setBounds(50,80,150,100);
        userId.setBounds(90, 120, 400, 100);
        userId.setFont(new Font(null, Font.ITALIC,24));
        welcome.setFont(new Font(null, Font.BOLD,30));


//        userId.setText(super.getUser().getUserId());


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

        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        balance.addActionListener(this);
        exit.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setVisible(false);
        if(e.getSource() == withdraw){
            Withdraw withdraw = new Withdraw();
        }
        else if(e.getSource() == deposit){
            Deposit deposit= new Deposit();

        }
        else if(e.getSource() == balance){
            Balance balance = new Balance();
        }
        else{
            BankAccount loginPage = new LoginPage("src/AccountInfo");
        }
    }
    public User getUser(){
        return this.user;
    }

    public static void main(String[] args) {
        //Bank bank = new Bank(new User("alex", 0,0));
    }

}
