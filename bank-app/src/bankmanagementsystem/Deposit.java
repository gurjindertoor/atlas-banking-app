package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit, back;
    String username, passwordString;

    Deposit(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Enter amount to deposit:");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(235, 300, 400, 20);
        image.add(text);


        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(175, 350, 320, 25);
        image.add(amount);


        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);


        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,855);
        setResizable(false);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit){
            String depositAmount = amount.getText();
            Date date = new Date();
            if (depositAmount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter an amount to deposit.");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+username+"', '"+passwordString+"', '"+date+"', 'Deposit', '"+depositAmount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$" + depositAmount + " successfully deposited.");
                    dispose();
                    new Transactions(username, passwordString);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        }
    }

    public static void main(String args[]){
        new Deposit("","");
    }
}
