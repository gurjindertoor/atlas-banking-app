package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Period;
import java.time.ZoneId;

public class SignupOne extends JFrame implements ActionListener{
    User user;

    JLabel formNumber, personalDetails, firstName, lastName, DOB, address, city, state, zipcode, email, confirmEmail;
    JTextField firstNameTextField, lastNameTextField, dobPlaceHolder, addressTextField, cityTextField, stateTextField, zipcodeTextField, emailTextField, confirmEmailTextField;
    JButton cancel, next;
    JDateChooser dateChooser;

    SignupOne(User user){
        this.user = user;
        setLayout(null);
        setTitle("New Account Application - Page 1: New Application");

        // Form Number
        formNumber = new JLabel("Application Form Number " + user.random);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formNumber.setBounds(140, 20, 600, 40);
        add(formNumber);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        // First Name
        firstName = new JLabel("First Name:");
        firstName.setFont(new Font("Raleway", Font.BOLD, 18));
        firstName.setBounds(100, 140, 200, 30);
        add(firstName);

        firstNameTextField = new JTextField();
        firstNameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        firstNameTextField.setBounds(300, 140, 400, 25);
        add(firstNameTextField);

        // Last Name
        lastName = new JLabel("Last Name:");
        lastName.setFont(new Font("Raleway", Font.BOLD, 18));
        lastName.setBounds(100, 200, 200, 30);
        add(lastName);

        lastNameTextField = new JTextField();
        lastNameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        lastNameTextField.setBounds(300, 200, 400, 25);
        add(lastNameTextField);

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

        // Address
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 320, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        addressTextField.setBounds(300, 320, 400, 25);
        add(addressTextField);

        // City
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 380, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        cityTextField.setBounds(300, 380, 400, 25);
        add(cityTextField);

        // State
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 440, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        stateTextField.setBounds(300, 440, 400, 25);
        add(stateTextField);

        // Zipcode
        zipcode = new JLabel("Zipcode:");
        zipcode.setFont(new Font("Raleway", Font.BOLD, 18));
        zipcode.setBounds(100, 500, 200, 30);
        add(zipcode);

        zipcodeTextField = new JTextField();
        zipcodeTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        zipcodeTextField.setBounds(300, 500, 400, 25);
        add(zipcodeTextField);

        // Email
        email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 560, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        emailTextField.setBounds(300, 560, 400, 25);
        add(emailTextField);

        // Confirm Email
        confirmEmail = new JLabel("Confirm Email:");
        confirmEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        confirmEmail.setBounds(100, 620, 200, 30);
        add(confirmEmail);

        confirmEmailTextField = new JTextField();
        confirmEmailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        confirmEmailTextField.setBounds(300, 620, 400, 25);
        add(confirmEmailTextField);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(100, 680, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 680, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String zipcode = zipcodeTextField.getText();
        // int zipcodeInt = Integer.parseInt(zipcode);
        String email = emailTextField.getText();
        String confirmEmail = confirmEmailTextField.getText();
        String outputDate;
        LocalDate currentDate = LocalDate.now();
        Date date = null;
        DateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy");
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (ae.getSource() == cancel){
                setVisible(false);
                new Login();
            } else if (firstName.equals("")){
                JOptionPane.showMessageDialog(null, "First Name Required");
            }
            else if (lastName.equals("")){
                JOptionPane.showMessageDialog(null, "Last Name Required");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth Required");
            }
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address Required");
            }
            else if (city.equals("")){
                JOptionPane.showMessageDialog(null, "City Required");
            }
            else if (state.equals("")){
                JOptionPane.showMessageDialog(null, "State Required");
            }
            else if (zipcode.equals("")){
                JOptionPane.showMessageDialog(null, "Zipcode Required");
            } else if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email Required");
            }
            else if (!email.contains("@")){
                JOptionPane.showMessageDialog(null, "Please enter valid email");
            }
            else if (confirmEmail.equals("")){
                JOptionPane.showMessageDialog(null, "Confirmation Email Required");
            }
            else if (!email.equals(confirmEmail)){
                JOptionPane.showMessageDialog(null, "Emails are not the same, please check spelling");
            } 
            
            date = inputFormat.parse(dob);
            LocalDate birthDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
            Period period = Period.between(birthDate, currentDate);
        
            if (period.getYears() < 18) {
                JOptionPane.showMessageDialog(null, "You must be at least 18 years old to sign up.");
            } 
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select count(*) from signup where email = '"+email+"'");
                if (rs.next()){
                    int emailCount = rs.getInt(1);
                    if (emailCount > 0) {
                        JOptionPane.showMessageDialog(null, "Email already in use.");
                    } else {
                        outputDate = outputFormat.format(date);
                
                        user.firstName = firstName;
                        user.lastName = lastName;
                        user.dob = outputDate;
                        user.address = address;
                        user.city = city;
                        user.state = state;
                        user.zipcode = zipcode;
                        user.email = email;
                        user.confirmEmail = confirmEmail; 
                
                        SignupTwo signupTwo = new SignupTwo(user);
                        dispose();
                    }
                }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        User user = new User("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        new SignupOne(user);
    }
}