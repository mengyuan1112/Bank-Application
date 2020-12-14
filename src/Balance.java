import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balance extends BankAccount implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel savingAccount = new JLabel("Saving Account: ");
    private JLabel checkingAccount = new JLabel("Checking Account: ");
    private JLabel checkingAmount = new JLabel();
    private JLabel savingAmount= new JLabel();
    private JButton exit = new JButton("Exit");
    Balance(){

        savingAccount.setBounds(20,50,300,30);
        checkingAccount.setBounds(20,100,300,30);
        savingAmount.setBounds(130,50,300,30);
        checkingAmount.setBounds(150,100,300,30);
        exit.setBounds(120,200,50,40);

        checkingAmount.setText(Integer.toString(super.getUser().getCheckingAccount()));
        savingAmount.setText(Integer.toString(super.getUser().getSavingAccount()));
        //
        //



        frame.add(savingAccount);
        frame.add(checkingAccount);
        frame.add(savingAmount);
        frame.add(checkingAmount);
        frame.add(exit);
        exit.addActionListener(this);

        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        Bank bank = new Bank();
    }

    public static void main(String[] args) {
        Balance balance = new Balance();
    }
}
