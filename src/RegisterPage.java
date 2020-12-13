import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisterPage implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel userId = new JLabel("UserID");
    private JLabel title = new JLabel("Register!");
    private JLabel password = new JLabel("Password");
    private JTextField userIdField = new JTextField();
    private JTextField passwordField = new JTextField();
    private JButton exit = new JButton("Back");
    private JButton register = new JButton("Register");
    private JLabel message = new JLabel();

    private UserList userList;
    private User user;



    RegisterPage(UserList userList ,String accountInfo){
        this.userList = userList;
        // Set up grid of Label and Button
        userId.setBounds(40,100,80,25);
        userIdField.setBounds(130,100,100,25);

        password.setBounds(40,150,80,25);
        passwordField.setBounds(130,150,100,25);

        title.setBounds(70,10,300,50);
        title.setFont(new Font(null,Font.BOLD,30));

        exit.setBounds(80, 240, 80,25);
        register.setBounds(80, 210, 80,25);
        message.setBounds(70, 170, 300, 25);

        exit.addActionListener(this);
        register.addActionListener(this);

        // Set frame
        frame.add(userId);
        frame.add(userIdField);
        frame.add(password);
        frame.add(passwordField);
        frame.add(title);
        frame.add(exit);
        frame.add(register);
        frame.add(message);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object operation = e.getSource();
       if(operation == register){
           String user = userIdField.getText();
           String password = passwordField.getText();
           try {
               writeFile(user, password,"src/AccountInfo");
               this.user = new User(user, 0,0);
               userList.addToList(this.user);
           } catch (IOException ioException) {
               ioException.printStackTrace();
           }

       }
       else{
           frame.setVisible(false);
           LoginPage loginPage = new LoginPage("src/AccountInfo",this.userList);
       }
    }


    public void writeFile(String user, String password, String fileName) throws IOException{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            boolean found = false;
            while (scanner.hasNext() && !found) {
                String line = scanner.nextLine();
                if (line.equals(user)) {
                    message.setText("Account exist");
                    return;
                }
            }
            if (!found) {
                FileWriter writer = new FileWriter(fileName,true);
                writer.write(user + '\n');
                writer.write(password + '\n');
                writer.close();
            }
            message.setText("Register success");
            return;
        }
    public static void main(String[] args) {
        RegisterPage registerPage = new RegisterPage(new UserList(),"scr/AccountInfo");
    }
}

