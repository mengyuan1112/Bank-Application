import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

public class SavingAccount extends User implements ActionListener {

    private JButton submit = new JButton("Submit");
    private JFrame frame = new JFrame();
    private JLabel amount = new JLabel("Amount");
    private JTextField amountField = new JTextField();
    private JButton exit = new JButton("Exit");
    private UserList userList;
    private User user;
    SavingAccount(UserList userList,User user){
        super(user.getUserId(), user.getCheckingAccount(),user.getSavingAccount());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
