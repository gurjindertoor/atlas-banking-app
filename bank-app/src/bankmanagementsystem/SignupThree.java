package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    User user;

    JLabel loginCreation, username, password, confirmPassword;
    JTextField usernameTextField;
    JPasswordField passwordField, confirmPasswordField;
    JButton previous, submit;
    String formNumber, firstName, lastName, dob, address, city, state, zipcode, email, confirmEmail, gender, maritalStatus, ownOrRent, occupation, education, income, phoneNumber, mobileNumber, accountType;

    SignupThree(User user){
        this.user = user;
        setLayout(null);
        setTitle("New Account Application - Page 3: Login Creation");

        // Login Creation
        loginCreation = new JLabel("Page 3: Login Creation");
        loginCreation.setFont(new Font("Raleway", Font.BOLD, 22));
        loginCreation.setBounds(290, 80, 400, 30);
        add(loginCreation);


        // Username
        username = new JLabel("Username:");
        username.setFont(new Font("Raleway", Font.BOLD, 18));
        username.setBounds(100, 140, 200, 30);
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        usernameTextField.setBounds(300, 140, 400, 30);
        add(usernameTextField);


        // Password
        password = new JLabel("Password:");
        password.setFont(new Font("Raleway", Font.BOLD, 18));
        password.setBounds(100, 200, 200, 30);
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 200, 400, 30);
        add(passwordField);


        // Confirm Password
        confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setFont(new Font("Raleway", Font.BOLD, 18));
        confirmPassword.setBounds(100, 260, 200, 30);
        add(confirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(300, 260, 400, 30);
        add(confirmPasswordField);


        // Previous Button
        previous = new JButton("Previous");
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 14));
        previous.setBounds(100, 320, 100, 30);
        previous.addActionListener(this);
        add(previous);

        
        // Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(620, 320, 100, 30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String username = usernameTextField.getText();
        char[] password = passwordField.getPassword();
        char[] confirmedPassword = confirmPasswordField.getPassword();

        if (ae.getSource() == previous){
            dispose();
            SignupTwo signupTwo = new SignupTwo(user);

            if (user.gender.equals("Male")){
                signupTwo.male.setSelected(true);
            } else if (user.gender.equals("Female")){
                signupTwo.female.setSelected(true);
            } else if (user.gender.equals("Other")){
                signupTwo.other.setSelected(true);
            } else {
                signupTwo.preferNotDisclose.setSelected(true);
            }

            if (user.maritalStatus.equals("Single")){
                signupTwo.single.setSelected(true);
            } else if (user.maritalStatus.equals("Married")){
                signupTwo.married.setSelected(true);
            } else if (user.maritalStatus.equals("Divorced")){
                signupTwo.divorced.setSelected(true);
            } else {
                signupTwo.widowed.setSelected(true);
            }

            if (user.ownOrRent.equals("Own")){
                signupTwo.ownProperty.setSelected(true);
            } else if (user.ownOrRent.equals("Rent")){
                signupTwo.rentProperty.setSelected(true);
            } else {
                signupTwo.otherProperty.setSelected(true);
            }

            signupTwo.occupations.setSelectedItem(user.occupation);
            signupTwo.educations.setSelectedItem(user.education);
            signupTwo.incomes.setSelectedItem(user.income);
            signupTwo.phoneNumberTextField.setText(user.phoneNumber);
            signupTwo.mobileNumberTextField.setText(user.mobileNumber);
            
            if (user.accountType.equals("Checking Account")){
                signupTwo.checking.setSelected(true);
            } else {
                signupTwo.saving.setSelected(true);
            }

        } else if (username.equals("")){
            JOptionPane.showMessageDialog(null, "Username Required");
        } else if (password.length <= 7){
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters");
        } else if (!new String(password).equals(new String(confirmedPassword))){
            JOptionPane.showMessageDialog(null, "Passwords are not the same");
        } else {;
            // Conn c = new Conn();
            // String query = "insert into signup values('"+user.random+"','"+user.firstName+"','"+user.lastName+"','"+user.dob+"','"+user.address+"', '"+user.city+"','"+user.state+"','"+user.zipcode+"','"+user.email+"','"+user.gender+"','"+user.maritalStatus+"','"+user.ownOrRent+"','"+user.occupation+"','"+user.education+"','"+user.income+"','"+user.phoneNumber+"','"+user.mobileNumber+"','"+user.accountType+"')";
            // c.s.executeUpdate(query);
        }
    }
}
// make object keep track of information, set fields of object / pass on object