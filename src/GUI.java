import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JLabel success;


    public static void main(String[] args) {

        /** Fundamental set up the GUI UI for Login;
         * @JFrame for frame
         * @JPanel for UI Panel
         * frame setup close operation
         * frame makes visible
         * panel add into frame
         */
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        // Set up User Label and Text Field
        userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // Set up Password Label and Text Field
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        passwordText = new JPasswordField(10);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // Set up button
        loginButton = new JButton("login");
        loginButton.setBounds(10,80,80,25);
        loginButton.addActionListener(new GUI());
        panel.add(loginButton);

        success = new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = String.valueOf(passwordText.getPassword());
        System.out.println(user+", " + password);
        success.setText("hello");
    }
}
