package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

public class GetStatement extends JFrame implements ActionListener{
    String username, passwordString;

    GetStatement(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        
        setLayout(null);
        setTitle("Account Statement");

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Atlas Banking");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel firstName = new JLabel();
        firstName.setBounds(20, 80, 300, 20);
        add(firstName);

        JLabel lastName = new JLabel();
        lastName.setBounds(20, 120, 300, 20);
        add(lastName);

        JLabel statements = new JLabel();
        statements.setBounds(20, 180, 400, 250);
        add(statements);

        JLabel balanceAmount = new JLabel();
        balanceAmount.setBounds(20, 500, 300, 20);
        add(balanceAmount);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from signup where username = '"+username+"' and password = '"+passwordString+"'");
            while (rs.next()){
                firstName.setText("First Name: " + rs.getString("firstName"));
                lastName.setText("Last Name: " + rs.getString("lastName"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // try {
        //     Conn conn = new Conn();
        //     int balance = 0;
        //     ResultSet rs = conn.s.executeQuery("select * from bank where username = '"+username+"' and password = '"+passwordString+"'");
        //     while (rs.next()){
        //         statements.setText(statements.getText() + "<html>" +rs.getString("date")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
        //         if (rs.getString("type").equals("Deposit")){
        //             balance += Integer.parseInt(rs.getString("amount"));
        //         } else {
        //             balance -= Integer.parseInt(rs.getString("amount"));
        //         }
        //     }
        //     balanceAmount.setText("Your current account balance is:   $" + balance);
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        // try {
        //     Conn conn = new Conn();
        //     int balance = 0;
        //     // ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE username = '"+username+"' AND password = '"+passwordString+"' ORDER BY STR_TO_DATE(date, '%Y-%m-%d') DESC");
        //     ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE username = '"+username+"' AND password = '"+passwordString+"' ORDER BY STR_TO_DATE(date, '%m/%d/%Y') DESC");
        //     // ResultSet rs = conn.s.executeQuery("select * from bank where username = '"+username+"' and password = '"+passwordString+"'");
        //     while (rs.next()){
        //         statements.setText(statements.getText() + "<html>" +rs.getString("date")  + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
        //         if (rs.getString("type").equals("Deposit")){
        //             balance += Integer.parseInt(rs.getString("amount"));
        //         } else {
        //             balance -= Integer.parseInt(rs.getString("amount"));
        //         }
        //     }
        //     balanceAmount.setText("Your current account balance is:   $" + balance);
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        
        try {
            Conn conn = new Conn();
            int balance = 0;
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE username = '"+username+"' AND password = '"+passwordString+"' ORDER BY STR_TO_DATE(date, '%a %b %d %T %Z %Y') DESC");

            // ResultSet rs = conn.s.executeQuery("select * from bank where username = '"+username+"' and password = '"+passwordString+"' order by str_to_date(date, '%a %b %d %T %Z %Y') desc");
            while (rs.next()){
                String dateString = rs.getString("date");
                Date date = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(dateString);
                String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                statements.setText("<html>" + formattedDate + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>" + statements.getText() + "<html>");
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceAmount.setText("Your current account balance is:   $" + balance);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        

        setSize(400, 600);
        setLocation(80, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    }
    public static void main(String args[]){
        new GetStatement("","");
    }
}