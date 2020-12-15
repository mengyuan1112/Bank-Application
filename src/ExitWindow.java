import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ExitWindow extends BankAccount implements ActionListener {
    private JFrame frame = new JFrame();
    private JButton ok = new JButton("OK");
    private JLabel message = new JLabel();
    ExitWindow(String message){
        ok.setBounds(60,40,50,20);
        this.message.setBounds(25,20,170,15);

        ok.addActionListener(this);
        frame.add(ok);
        frame.add(this.message);

        this.message.setText(message);


        frame.setSize(170,100);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(message.getText().contains("success")){
            frame.setVisible(false);
            BankAccount loginPage = new LoginPage("src/AccountInfo");
        }
        if(message.getText().contains("D")){
            frame.setVisible(false);
            Deposit deposit = new Deposit();
        }
        if(message.getText().contains("W")){
            frame.setVisible(false);
           Withdraw withdraw = new Withdraw();
        }
        frame.setVisible(false);
    }

    public static void main(String[] args) {
//        ExitWindow a = new ExitWindow();
    }
}
