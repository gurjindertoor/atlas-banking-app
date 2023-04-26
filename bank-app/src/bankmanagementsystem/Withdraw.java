package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw20, withdraw40, withdraw60, withdraw80, withdraw100, withdraw200, withdraw, back;
    String username, passwordString;

    Withdraw(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Enter amount to withdraw:");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(235, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(175, 350, 320, 25);
        image.add(amount);

        // Withdraw 20
        withdraw20 = new JButton("$20");
        withdraw20.setBounds(170, 415, 150, 30);
        withdraw20.addActionListener(this);
        image.add(withdraw20);

        // Withdraw 40
        withdraw40 = new JButton("$40");
        withdraw40.setBounds(170, 450, 150, 30);
        withdraw40.addActionListener(this);
        image.add(withdraw40);

        // Withdraw 60
        withdraw60 = new JButton("$60");
        withdraw60.setBounds(170, 485, 150, 30);
        withdraw60.addActionListener(this);
        image.add(withdraw60);

        // Withdraw 80
        withdraw80 = new JButton("$80");
        withdraw80.setBounds(170, 520, 150, 30);
        withdraw80.addActionListener(this);
        image.add(withdraw80);

        // Withdraw 100
        withdraw100 = new JButton("$100");
        withdraw100.setBounds(352, 415, 150, 30);
        withdraw100.addActionListener(this);
        image.add(withdraw100);

        // Withdraw 500
        withdraw200 = new JButton("$200");
        withdraw200.setBounds(352, 450, 150, 30);
        withdraw200.addActionListener(this);
        image.add(withdraw200);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(352, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        } else {
            String withdrawAmount = "";
            String withdrawAmountX = amount.getText();
            
            if (ae.getSource() == withdraw) {
                if (withdrawAmountX.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter in quantities of $20.");
                } else if (Integer.parseInt(withdrawAmountX) % 20 != 0) {
                    JOptionPane.showMessageDialog(null, "Please enter in quantities of $20.");
                } else if (Integer.parseInt(withdrawAmountX) == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a value greater than 0.");
                } else if (Integer.parseInt(withdrawAmountX) <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a value greater than 0.");
                } else {
                    withdrawAmount = withdrawAmountX;
                }
            } else if (ae.getSource() instanceof JButton) {
                String buttonText = ((JButton) ae.getSource()).getText();
                if (buttonText.matches("^\\$[1-9][0-9]*$") && Integer.parseInt(buttonText.substring(1)) % 20 == 0) {
                    withdrawAmount = buttonText.substring(1);
                }
            }
            
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

                if (ae.getSource() != back && balance < Integer.parseInt(withdrawAmount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance.");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+username+"', '"+passwordString+"', '"+date+"', 'Withdrawal', '"+withdrawAmount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$" + withdrawAmount + " withdrawal successful.");
                dispose();
                new Transactions(username, passwordString);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]){
        new Withdraw("","");
    }
}