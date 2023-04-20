package bankmanagementsystem;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel label, text, username, password;
    JButton login, signup, clear;
    JTextField usernameTextField;
    JPasswordField passwordTextField;

    Login(){
        setTitle("Atlas Banking Portal");

        setLayout(null);

        // Icon
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/logo.jpg"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);


        // Text
        text = new JLabel("Welcome to Atlas Banking");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 400, 40);
        add(text);


        // Username
        username = new JLabel("Username:");
        username.setFont(new Font("Raleway", Font.BOLD, 16));
        username.setBounds(120, 150, 150, 30);
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(300, 150, 250, 30);
        usernameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        add(usernameTextField);


        // Password
        password = new JLabel("Password:");
        password.setFont(new Font("Raleway", Font.BOLD, 16));
        password.setBounds(120, 220, 250, 30);
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(300, 220, 250, 30);
        add(passwordTextField);


        // Login Button
        login = new JButton("Sign In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        // Clear Button
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


        // Signup Button
        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            usernameTextField.setText("");
            passwordTextField.setText("");
        } else if (ae.getSource() == login) {

        } else if (ae.getSource() == signup){
            dispose();
            new SignupOne(null);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}