package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class ForgotLogin extends JFrame implements ActionListener{

    JLabel text, firstName, lastName, DOB, securityQuestion1, securityQuestion2, securityQuestion3;
    JComboBox securityQuestionBox1, securityQuestionBox2, securityQuestionBox3;
    JTextField firstNameField, lastNameField, dobPlaceHolder, securityQuestionAnswer1, securityQuestionAnswer2, securityQuestionAnswer3;
    JDateChooser dateChooser;
    JButton previous, submit;

    ForgotLogin(){
        setLayout(null);
        setTitle("Forgot Password");
        // Login Creation
        text = new JLabel("Forgot Password");
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setBounds(320, 80, 400, 30);
        add(text);
  
        // First Name
        firstName = new JLabel("First Name:");
        firstName.setFont(new Font("Raleway", Font.BOLD, 18));
        firstName.setBounds(100, 140, 200, 30);
        add(firstName);
    
        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Raleway", Font.BOLD, 12));
        firstNameField.setBounds(300, 140, 400, 30);
        add(firstNameField);
    
        // Last Name
        lastName = new JLabel("Last Name:");
        lastName.setFont(new Font("Raleway", Font.BOLD, 18));
        lastName.setBounds(100, 200, 200, 30);
        add(lastName);
    
        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Raleway", Font.BOLD, 12));
        lastNameField.setBounds(300, 200, 400, 30);
        add(lastNameField);

        // Date of Birth/DOB
        DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        DOB.setBounds(100, 260, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 260, 400, 30);
        dateChooser.setForeground(Color.BLACK);

        // Add placeholder text
        dobPlaceHolder = ((JTextField) dateChooser.getDateEditor().getUiComponent());
        dobPlaceHolder.setText("YYYY-MM-DD");
        dobPlaceHolder.setForeground(Color.BLACK);

        dobPlaceHolder.addFocusListener(new FocusListener() {
            private boolean hasFocus = false;
        
            @Override
            public void focusGained(FocusEvent e) {
                if (!hasFocus) {
                    dobPlaceHolder.setText("");
                }
                hasFocus = true;
            }
        
            @Override
            public void focusLost(FocusEvent e) {
                if (!dateChooser.isVisible()) {
                    dobPlaceHolder.setText("YYYY-MM-DD");
                    hasFocus = false;
                }
            }
        });
        
        add(dateChooser);

        // Security Question 1
        String securityQuestionList[] = {"What is your favorite color?", "What is your favorite animal?", "What is your favorite car?", "What is your favorite food?", "What is your favorite sport?"};

        securityQuestion1 = new JLabel("Security Question 1:");
        securityQuestion1.setFont(new Font("Raleway", Font.BOLD, 18));
        securityQuestion1.setBounds(100, 320, 200, 30);
        add(securityQuestion1);

        securityQuestionBox1 = new JComboBox(securityQuestionList);
        securityQuestionBox1.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionBox1.setBackground(Color.WHITE);
        securityQuestionBox1.setBounds(300, 320, 400, 25);
        add(securityQuestionBox1);

        securityQuestionAnswer1 = new JTextField();
        securityQuestionAnswer1.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionAnswer1.setBackground(Color.WHITE);
        securityQuestionAnswer1.setBounds(300, 360, 400, 25);
        add(securityQuestionAnswer1);

        // Security Question 2
        securityQuestion2 = new JLabel("Security Question 2:");
        securityQuestion2.setFont(new Font("Raleway", Font.BOLD, 18));
        securityQuestion2.setBounds(100, 400, 200, 30);
        add(securityQuestion2);

        securityQuestionBox2 = new JComboBox(securityQuestionList);
        securityQuestionBox2.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionBox2.setBackground(Color.WHITE);
        securityQuestionBox2.setBounds(300, 400, 400, 25);
        add(securityQuestionBox2);

        securityQuestionAnswer2 = new JTextField();
        securityQuestionAnswer2.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionAnswer2.setBackground(Color.WHITE);
        securityQuestionAnswer2.setBounds(300, 440, 400, 25);
        add(securityQuestionAnswer2);

        // Security Question 3
        securityQuestion3 = new JLabel("Security Question 3:");
        securityQuestion3.setFont(new Font("Raleway", Font.BOLD, 18));
        securityQuestion3.setBounds(100, 480, 200, 30);
        add(securityQuestion3);

        securityQuestionBox3 = new JComboBox(securityQuestionList);
        securityQuestionBox3.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionBox3.setBackground(Color.WHITE);
        securityQuestionBox3.setBounds(300, 480, 400, 25);
        add(securityQuestionBox3);

        securityQuestionAnswer3 = new JTextField();
        securityQuestionAnswer3.setFont(new Font("Raleway", Font.BOLD, 12));
        securityQuestionAnswer3.setBackground(Color.WHITE);
        securityQuestionAnswer3.setBounds(300, 520, 400, 25);
        add(securityQuestionAnswer3);

        previous = new JButton("Previous");
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 14));
        previous.setBounds(100, 580, 100, 30);
        previous.addActionListener(this);
        add(previous);
    
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(620, 580, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String securityAnswer1 = securityQuestionAnswer1.getText();
        String securityAnswer2 = securityQuestionAnswer2.getText();
        String securityAnswer3 = securityQuestionAnswer3.getText();
        String outputDate;
        Date date = null;
        DateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Conn conn = new Conn();

        try {
            if (ae.getSource() == previous){
                dispose();
                new Login();
            } else if (firstName.equals("")){
                JOptionPane.showMessageDialog(null, "First Name Required.");
            } else if (lastName.equals("")){
                JOptionPane.showMessageDialog(null, "Last Name Required.");
            } else if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth Required.");
            } else if (securityAnswer1.equals("")){
                JOptionPane.showMessageDialog(null, "Security Question Answer 1 Required.");
            } else if (securityAnswer2.equals("")){
                JOptionPane.showMessageDialog(null, "Security Question Answer 2 Required.");
            } else if (securityAnswer3.equals("")){
                JOptionPane.showMessageDialog(null, "Security Question Answer 3 Required.");
            } else {
                date = inputFormat.parse(dob);
                outputDate = outputFormat.format(date);

                ResultSet rs = conn.s.executeQuery("select * from signup where firstName = '"+firstName+"' and lastName ='"+lastName+"' and dob = '"+outputDate+"' and securityQuestion1 = '"+securityAnswer1+"' and securityQuestion2 = '"+securityAnswer2+"' and securityQuestion3 = '"+securityAnswer3+"'");
                if (rs.next()){
                    String message = "Username: " + rs.getString("username") + "\n" + "Password: " + rs.getString("password");
                    JOptionPane.showMessageDialog(null, message);
                    dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials.");
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
