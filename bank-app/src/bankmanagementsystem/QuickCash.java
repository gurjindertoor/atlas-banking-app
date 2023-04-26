package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class QuickCash extends JFrame implements ActionListener{

    JTextField amount;
    JButton quickCash20, quickCash40, quickCash60, quickCash80, quickCash100, quickCash200, quickCash500, back;
    String username, passwordString;

    QuickCash(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(210, 300, 400, 20);
        image.add(text);

        // Quick Cash 20
        quickCash20 = new JButton("$20");
        quickCash20.setBounds(170, 415, 150, 30);
        quickCash20.addActionListener(this);
        image.add(quickCash20);

        // Quick Cash 40
        quickCash40 = new JButton("$40");
        quickCash40.setBounds(170, 450, 150, 30);
        quickCash40.addActionListener(this);
        image.add(quickCash40);

        // Quick Cash 60
        quickCash60 = new JButton("$60");
        quickCash60.setBounds(170, 485, 150, 30);
        quickCash60.addActionListener(this);
        image.add(quickCash60);

        // Quick Cash 80
        quickCash80 = new JButton("$80");
        quickCash80.setBounds(170, 520, 150, 30);
        quickCash80.addActionListener(this);
        image.add(quickCash80);

        // Quick Cash 100
        quickCash100 = new JButton("$100");
        quickCash100.setBounds(352, 415, 150, 30);
        quickCash100.addActionListener(this);
        image.add(quickCash100);

        // Quick Cash 200
        quickCash200 = new JButton("$200");
        quickCash200.setBounds(352, 450, 150, 30);
        quickCash200.addActionListener(this);
        image.add(quickCash200);

        // Quick Cash 500
        quickCash500 = new JButton("$500");
        quickCash500.setBounds(352, 485, 150, 30);
        quickCash500.addActionListener(this);
        image.add(quickCash500);

        // Back
        back = new JButton("Back");
        back.setBounds(352, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,855);
        setResizable(false);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        } else {
            String quickCashAmount = ((JButton)ae.getSource()).getText().substring(1);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where username = '"+username+"' and password = '"+passwordString+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(quickCashAmount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance.");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+username+"', '"+passwordString+"', '"+date+"', 'Withdrawal', '"+quickCashAmount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$" + quickCashAmount + " withdrawal successful.");
                dispose();
                new Transactions(username, passwordString);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]){
        new QuickCash("", "");
    }
}
