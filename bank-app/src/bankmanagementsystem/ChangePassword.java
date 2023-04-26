package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class ChangePassword extends JFrame implements ActionListener{
    JLabel text, currentPassword, newPassword, confirmPassword;
    JPasswordField currentPasswordField, newPasswordField, confirmPasswordField;
    String username, passwordString;
    JButton confirm, back;

    ChangePassword(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;

        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE PASSWORD");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 300, 400, 20);
        image.add(text);

        // Old
        currentPassword = new JLabel("Current Password:");
        currentPassword.setFont(new Font("System", Font.BOLD, 16));
        currentPassword.setForeground(Color.WHITE);
        currentPassword.setBounds(165, 340, 180, 25);
        image.add(currentPassword);

        currentPasswordField = new JPasswordField();
        currentPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        currentPasswordField.setBounds(320, 340, 180, 25);
        image.add(currentPasswordField);

        // New
        newPassword = new JLabel("New Password:");
        newPassword.setFont(new Font("System", Font.BOLD, 16));
        newPassword.setForeground(Color.WHITE);
        newPassword.setBounds(165, 380, 180, 25);
        image.add(newPassword);

        newPasswordField = new JPasswordField();
        newPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        newPasswordField.setBounds(320, 380, 180, 25);
        image.add(newPasswordField);

        // Confirm
        confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("System", Font.BOLD, 16));
        confirmPassword.setForeground(Color.WHITE);
        confirmPassword.setBounds(165, 420, 180, 25);
        image.add(confirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Raleway", Font.BOLD, 25));
        confirmPasswordField.setBounds(320, 420, 180, 25);
        image.add(confirmPasswordField);

        confirm = new JButton("Confirm");
        confirm.setBounds(352, 485, 150, 30);
        confirm.addActionListener(this);
        image.add(confirm);

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
        char[] currentPassword = currentPasswordField.getPassword();
        char[] newPassword = newPasswordField.getPassword();
        char[] confirmPassword = confirmPasswordField.getPassword();

        String currentPasswordString = String.valueOf(currentPassword);
        String newPasswordString = String.valueOf(newPassword);
        String confirmPasswordString = String.valueOf(confirmPassword);

        if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        } else {
            try {
                if (newPasswordString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter password.");
                    return;
                } 
                
                if (confirmPasswordString.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter password.");
                    return;
                }
                
                if (!newPasswordString.equals(confirmPasswordString)){
                    JOptionPane.showMessageDialog(null, "Passwords are not the same.");
                    return;
                } 

                if (newPassword.length <= 7) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 7 characters long.");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set password = '"+newPasswordString+"' where username = '"+username+"' and password = '"+passwordString+"'";
                String query2 = "update signup set password = '"+newPasswordString+"' where username = '"+username+"' and password = '"+passwordString+"'";

                ResultSet rs = conn.s.executeQuery("select * from signup where username = '"+username+"' and password = '"+passwordString+"'");
                while (rs.next()){
                    if (rs.getString("password").equals(currentPasswordString)){
                        conn.s.execute(query1);
                        conn.s.execute(query2);
                        JOptionPane.showMessageDialog(null, "Password changed successfully.");
                        dispose();
                        new Transactions(username, passwordString);
                    } else {
                        JOptionPane.showMessageDialog(null, "Old password is incorrect");
                    }
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]){
        new ChangePassword("", "");
    }
}
