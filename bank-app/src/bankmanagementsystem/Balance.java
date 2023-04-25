package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener{

    JButton back;
    String username, passwordString;

    Balance(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where username = '"+username+"' and password = '"+passwordString+"'");
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Balance is: $" + balance);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(235, 300, 400, 20);
        image.add(text);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setResizable(false);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        }
    }

    public static void main(String args[]){
        new Balance("","");
    }
}

