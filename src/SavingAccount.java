import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavingAccount extends BankAccount implements ActionListener {

    private JButton submit = new JButton("Submit");
    private JFrame frame = new JFrame();
    private JLabel amount = new JLabel("Amount: ");
    private JTextField amountField = new JTextField();
    private JButton exit = new JButton("Exit");
    private JLabel title = new JLabel();
    private String operation;
    SavingAccount(String type){
        this.operation = type;
        title.setBounds(40, 30,400,50);

        title.setFont(new Font(null,Font.BOLD,21));
        submit.setBounds(135, 230,100,50);
        exit.setBounds(145, 300,70,30);
        amountField.setBounds(150,150, 170,50);
        amount.setBounds(60,150, 170, 50);
        title.setText(type + " Saving Account");


        frame.add(submit);
        frame.add(amount);
        frame.add(exit);
        frame.add(amountField);
        frame.add(title);

        submit.addActionListener(this);
        exit.addActionListener(this);


        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if (this.operation.equals("Withdraw")) {
                int accountMoney = super.getUser().getSavingAccount();
                int curMoney = Integer.parseInt(this.amountField.getText());
                if (accountMoney < curMoney) {
                    ExitWindow exitWindow = new ExitWindow("Not enough money");
                    return;
                }
                frame.setVisible(false);
                ExitWindow exitWindow = new ExitWindow("Withdraw: " + this.amountField.getText());
                super.getUser().WithDraw("Saving Account",curMoney);
            }
            if (this.operation.equals("Deposit")) {
                int curMoney = Integer.parseInt(this.amountField.getText());
                super.getUser().Deposit("Saving Account",curMoney);
                frame.setVisible(false);
                ExitWindow exitWindow = new ExitWindow("Deposit: " + this.amountField.getText());
            }
        }
        else{
            frame.setVisible(false);
            Bank bank = new Bank();
        }

    }

    public static void main(String[] args) {
//        SavingAccount savingAccount = new SavingAccount();
    }
}
