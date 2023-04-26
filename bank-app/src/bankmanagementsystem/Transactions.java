package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, quickCash, changePassword, applyCreditCard, withdraw, statement, balance, exit;
    
    String username, passwordString;

    Transactions(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;

        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select Transaction:");
        text.setBounds(235, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        // Deposit
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        // Fast Cash
        quickCash = new JButton("Quick Cash");
        quickCash.setBounds(170, 450, 150, 30);
        quickCash.addActionListener(this);
        image.add(quickCash);

        // Change Password
        changePassword = new JButton("Change Password");
        changePassword.setBounds(170, 485, 150, 30);
        changePassword.addActionListener(this);
        image.add(changePassword);

        // Apply Credit Card
        applyCreditCard = new JButton("Apply Credit Card");
        applyCreditCard.setBounds(170, 520, 150, 30);
        applyCreditCard.addActionListener(this);
        image.add(applyCreditCard);

        // Withdraw
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(352, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        // Statement
        statement = new JButton("Statement");
        statement.setBounds(352, 450, 150, 30);
        statement.addActionListener(this);
        image.add(statement);

        // Balance
        balance = new JButton("Balance");
        balance.setBounds(352, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        // Exit
        exit = new JButton("Exit");
        exit.setBounds(352, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,855);
        setResizable(false);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){
            dispose();
            new Deposit(username, passwordString);
        } else if (ae.getSource() == quickCash){
            dispose();
            new QuickCash(username, passwordString);
        } else if (ae.getSource() == changePassword){
            dispose();
            new ChangePassword(username, passwordString);
        } else if (ae.getSource() == applyCreditCard){
            dispose();
            new ApplyCreditCard(username, passwordString);
        } else if (ae.getSource() == withdraw){
            dispose();
            new Withdraw(username, passwordString);
        } else if (ae.getSource() == statement){
            // dispose();
            new GetStatement(username, passwordString);
        } else if (ae.getSource() == balance){
            dispose();
            new Balance(username, passwordString);
        } 
    }

    public static void main(String args[]){
        new Transactions("", "");
    }
}
