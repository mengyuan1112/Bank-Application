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
        frame.setVisible(false);
    }

    public static void main(String[] args) {
//        ExitWindow a = new ExitWindow();
    }
}
