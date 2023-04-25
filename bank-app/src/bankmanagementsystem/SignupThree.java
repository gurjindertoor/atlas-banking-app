package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    User user;

    JLabel loginCreation, username, password, confirmPassword, securityQuestion1, securityQuestion2, securityQuestion3;
    JTextField usernameTextField, securityQuestionAnswer1, securityQuestionAnswer2, securityQuestionAnswer3;
    JComboBox securityQuestionBox1, securityQuestionBox2, securityQuestionBox3;
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


        // // Security Question 1
        // String securityQuestionList[] = {"What is your favorite color?", "What is your favorite animal?", "What is your favorite car?", "What is your favorite food?", "What is your favorite sport?"};

        // securityQuestion1 = new JLabel("Security Question 1:");
        // securityQuestion1.setFont(new Font("Raleway", Font.BOLD, 18));
        // securityQuestion1.setBounds(100, 320, 200, 30);
        // add(securityQuestion1);

        // securityQuestionBox1 = new JComboBox(securityQuestionList);
        // securityQuestionBox1.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionBox1.setBackground(Color.WHITE);
        // securityQuestionBox1.setBounds(300, 320, 400, 25);
        // add(securityQuestionBox1);

        // securityQuestionAnswer1 = new JTextField();
        // securityQuestionAnswer1.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionAnswer1.setBackground(Color.WHITE);
        // securityQuestionAnswer1.setBounds(300, 360, 400, 25);
        // add(securityQuestionAnswer1);

        // // Security Question 2
        // securityQuestion2 = new JLabel("Security Question 2:");
        // securityQuestion2 = new JLabel("Security Question 1:");
        // securityQuestion2.setFont(new Font("Raleway", Font.BOLD, 18));
        // securityQuestion2.setBounds(100, 400, 200, 30);
        // add(securityQuestion2);

        // securityQuestionBox2 = new JComboBox(securityQuestionList);
        // securityQuestionBox2.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionBox2.setBackground(Color.WHITE);
        // securityQuestionBox2.setBounds(300, 400, 400, 25);
        // add(securityQuestionBox2);

        // securityQuestionAnswer2 = new JTextField();
        // securityQuestionAnswer2.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionAnswer2.setBackground(Color.WHITE);
        // securityQuestionAnswer2.setBounds(300, 440, 400, 25);
        // add(securityQuestionAnswer2);

        // // Security Question 3
        // securityQuestion3 = new JLabel("Security Question 3:");
        // securityQuestion3 = new JLabel("Security Question 1:");
        // securityQuestion3.setFont(new Font("Raleway", Font.BOLD, 18));
        // securityQuestion3.setBounds(100, 480, 200, 30);
        // add(securityQuestion3);

        // securityQuestionBox3 = new JComboBox(securityQuestionList);
        // securityQuestionBox3.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionBox3.setBackground(Color.WHITE);
        // securityQuestionBox3.setBounds(300, 480, 400, 25);
        // add(securityQuestionBox3);

        // securityQuestionAnswer3 = new JTextField();
        // securityQuestionAnswer3.setFont(new Font("Raleway", Font.BOLD, 12));
        // securityQuestionAnswer3.setBackground(Color.WHITE);
        // securityQuestionAnswer3.setBounds(300, 520, 400, 25);
        // add(securityQuestionAnswer3);

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

        try{
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
            } else {
                Conn conn = new Conn();
                String query = "insert into signup values('"+user.random+"','"+user.firstName+"','"+user.lastName+"','"+user.dob+"','"+user.address+"', '"+user.city+"','"+user.state+"','"+user.zipcode+"','"+user.email+"','"+user.gender+"','"+user.maritalStatus+"','"+user.ownOrRent+"','"+user.occupation+"','"+user.education+"','"+user.income+"','"+user.phoneNumber+"','"+user.mobileNumber+"','"+user.accountType+"', '"+username+"', '"+String.valueOf(password)+"')";
                conn.s.executeUpdate(query);
                dispose();
                new Login();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}