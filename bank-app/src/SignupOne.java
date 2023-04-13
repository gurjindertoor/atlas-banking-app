import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame{

    SignupOne(){

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNum = new JLabel("Application Form Number " + random);
        formNum.setFont(new Font("Raleway", Font.BOLD, 38));
        formNum.setBounds(140, 20, 600, 40);
        add(formNum);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel firstName = new JLabel("First Name*:");
        firstName.setFont(new Font("Raleway", Font.BOLD, 18));
        firstName.setBounds(100, 140, 200, 30);
        add(firstName);

        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        firstNameTextField.setBounds(300, 140, 400, 25);
        add(firstNameTextField);

        JLabel middleName = new JLabel("Middle Name:");
        middleName.setFont(new Font("Raleway", Font.BOLD, 18));
        middleName.setBounds(100, 200, 200, 30);
        add(middleName);

        JTextField middleNameTextField = new JTextField();
        middleNameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        middleNameTextField.setBounds(300, 200, 400, 25);
        add(middleNameTextField);

        JLabel lastName = new JLabel("Last Name*:");
        lastName.setFont(new Font("Raleway", Font.BOLD, 18));
        lastName.setBounds(100, 260, 200, 30);
        add(lastName);

        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        lastNameTextField.setBounds(300, 260, 400, 25);
        add(lastNameTextField);

        JLabel DOB = new JLabel("Date of Birth*:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        DOB.setBounds(100, 320, 200, 30);
        add(DOB);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 320, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel address = new JLabel("Address*:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 380, 200, 30);
        add(address);

        JTextField addressEmailTextField = new JTextField();
        addressEmailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        addressEmailTextField.setBounds(300, 380, 400, 25);
        add(addressEmailTextField);

        JLabel city = new JLabel("City*:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 440, 200, 30);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        cityTextField.setBounds(300, 440, 400, 25);
        add(cityTextField);

        JLabel state = new JLabel("State*:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 500, 200, 30);
        add(state);

        JTextField stateEmailTextField = new JTextField();
        stateEmailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        stateEmailTextField.setBounds(300, 500, 400, 25);
        add(stateEmailTextField);

        JLabel zipcode = new JLabel("Zipcode*:");
        zipcode.setFont(new Font("Raleway", Font.BOLD, 18));
        zipcode.setBounds(100, 560, 200, 30);
        add(zipcode);

        JTextField zipcodeEmailTextField = new JTextField();
        zipcodeEmailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        zipcodeEmailTextField.setBounds(300, 560, 400, 25);
        add(zipcodeEmailTextField);

        JLabel email = new JLabel("Email*:");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 620, 200, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        emailTextField.setBounds(300, 620, 400, 25);
        add(emailTextField);

        JLabel confirmEmail = new JLabel("Confirm Email*:");
        confirmEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        confirmEmail.setBounds(100, 680, 200, 30);
        add(confirmEmail);

        JTextField confirmEmailTextField = new JTextField();
        confirmEmailTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        confirmEmailTextField.setBounds(300, 680, 400, 25);
        add(confirmEmailTextField);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 720, 80, 30);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String args[]){
        new SignupOne();
    }
}
