package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, fastCash, changePin, withdraw, statement, balance, exit;
 
    Transactions(){
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
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        // Change Pin
        changePin = new JButton("Change Pin");
        changePin.setBounds(170, 485, 150, 30);
        changePin.addActionListener(this);
        image.add(changePin);

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

        setSize(900,900);
        setResizable(false);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit().setVisible(true);
        } else if (ae.getSource() == fastCash){

        } else if (ae.getSource() == changePin){

        } else if (ae.getSource() == withdraw){

        } else if (ae.getSource() == statement){

        } else if (ae.getSource() == balance){

        } 
    }

    public static void main(String args[]){
        new Transactions();
    }
}
