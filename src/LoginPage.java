import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage extends BankAccount implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel userId = new JLabel("User");
    private JLabel password = new JLabel("Password");
    private JTextField userText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();
    private JButton login = new JButton("Login");
    private JLabel success = new JLabel();
    private JButton register = new JButton("Register");


    LoginPage(String file){

        userId.setBounds(10,20,80,25);
        password.setBounds(10,50,80,25);
        userText.setBounds(100,20,165,25);
        passwordText.setBounds(100,50,165,25);
        login.setBounds(10,80,80,25);
        register.setBounds(200,80,80,25);
        success.setBounds(105,110,150,25);


        success.setFont(new Font(null, Font.ITALIC,15));


        login.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.add(userId);
        frame.add(userText);
        frame.add(login);
        frame.add(passwordText);
        frame.add(password);
        frame.add(success);
        frame.add(register);
        login.addActionListener(this);
        register.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String userId = userText.getText();
            String password = String.valueOf(passwordText.getPassword());
            boolean found = false;
            try{
                found = readFile(userId,password,"src/AccountInfo");

            } catch (IOException ioException){
                ioException.printStackTrace();
            }
            if(found){
                User user = super.getUser(userId);
                frame.setVisible(false);
                BankAccount bank = new Bank(user);
            }
            else{
                success.setText("Wrong Input");
            }
        }
        else{
            frame.setVisible(false);
            BankAccount registerPage = new RegisterPage();
        }
    }

    public boolean readFile(String user, String password, String fileName) throws IOException {
        boolean IdFound = false;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(!IdFound && scanner.hasNext()){
            String line = scanner.nextLine();
            if(line.equals(user)){
                String nextLine = scanner.nextLine();
                if(nextLine.equals(password)){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage("src/AccountInfo");
    }
}
