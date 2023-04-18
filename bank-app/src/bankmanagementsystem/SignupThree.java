package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{

    JLabel loginCreation, username, password, confirmPassword;
    JTextField usernameTextField;
    JPasswordField passwordField, confirmPasswordField;
    JButton previous, submit;

    SignupThree(){
        setLayout(null);
        setTitle("New Account Application - Page 3: Login Creation");

        // Login Creation
        loginCreation = new JLabel("Page 3: Login Creation");
        loginCreation.setFont(new Font("Raleway", Font.BOLD, 22));
        loginCreation.setBounds(290, 80, 400, 30);
        add(loginCreation);


        // Username
        username = new JLabel("Username:");
        username.setFont(new Font("Raleway", Font.BOLD, 18));
        username.setBounds(100, 140, 200, 30);
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        usernameTextField.setBounds(300, 140, 400, 30);
        add(usernameTextField);


        // Password
        password = new JLabel("Password:");
        password.setFont(new Font("Raleway", Font.BOLD, 18));
        password.setBounds(100, 200, 200, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 200, 400, 30);
        add(passwordField);


        // Confirm Password
        confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("Raleway", Font.BOLD, 18));
        confirmPassword.setBounds(100, 260, 200, 30);
        add(confirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(300, 260, 400, 30);
        add(confirmPasswordField);

        
        // Previous Button
        previous = new JButton("Previous");
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 14));
        previous.setBounds(100, 320, 100, 30);
        previous.addActionListener(this);
        add(previous);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(620, 320, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String username = usernameTextField.getText();
        char[] password = passwordField.getPassword();
        char[] confirmedPassword = confirmPasswordField.getPassword();

        if (username.equals("")){
            JOptionPane.showMessageDialog(null, "Username Required");
        } else if (password.length <= 7){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters");
        } else if (!new String(password).equals(new String(confirmedPassword))){
            JOptionPane.showMessageDialog(null, "Passwords are not the same");
        }

        if (ae.getSource() == submit){

        }
    }
    public static void main(String args[]){
        new SignupThree();
    }
}