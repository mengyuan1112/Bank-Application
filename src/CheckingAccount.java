import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckingAccount extends Bank implements ActionListener {
    private JButton submit = new JButton("Submit");
    private JFrame frame = new JFrame();
    private JLabel amount = new JLabel("Amount: ");
    private JTextField amountField = new JTextField();
    private JButton exit = new JButton("Exit");
    private JLabel title = new JLabel();
    private String operation;
    CheckingAccount(String type){

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


        frame.setLayout(null);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit) {
            if (this.operation.equals("Withdraw")) {
                int accountMoney = super.user.getSavingAccount();
                int curMoney = Integer.parseInt(this.amountField.getText());
//            if(curMoney > accountMoney){
//
//                return;
//            }
                super.user.checkingAccountWithDraw(curMoney);
            }
            if (this.operation.equals("Deposit")) {
                int curMoney = Integer.parseInt(this.amountField.getText());
                super.user.checkingAccountDeposit(curMoney);
            }
        }
        else{
            Bank bank = new Bank();
        }
    }

}
