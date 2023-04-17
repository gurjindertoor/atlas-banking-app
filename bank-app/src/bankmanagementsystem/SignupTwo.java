package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    long random;
    JTextField phoneNumberTextField, mobileNumberTextField;
    JButton next, previous;
    JComboBox occupations, educations, incomes;
    JRadioButton male, female, other, preferNotDisclose, single, married, divorced, widowed, checking, saving, creditCardYes, creditCardNo;
    String formNumber, firstName, lastName, dob, address, city, state, zipcode, email, confirmEmail;

    SignupTwo(String formNumber, String firstName, String lastName, String dob, String address, String city, String state, String zipcode, String email, String confirmEmail){
        this.formNumber = formNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.confirmEmail = confirmEmail;

        setLayout(null);
        setTitle("New Account Application - Page 2");

        // JLabel application = new JLabel("New Account Application");
        // application.setFont(new Font("Raleway", Font.BOLD, 38));
        // application.setBounds(140, 20, 600, 40);
        // add(application);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 140, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        preferNotDisclose = new JRadioButton("Prefer to not Disclose");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        genderGroup.add(preferNotDisclose);

        male.setBounds(300, 140, 60, 30);
        female.setBounds(375, 140, 75, 30);
        other.setBounds(450, 140, 60, 30);
        preferNotDisclose.setBounds(525, 140, 175, 30);

        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        other.setBackground(Color.WHITE);
        preferNotDisclose.setBackground(Color.WHITE);

        add(male);
        add(female);
        add(other);
        add(preferNotDisclose);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        maritalStatus.setBounds(100, 200, 200, 30);
        add(maritalStatus);

        single = new JRadioButton("Single");
        married = new JRadioButton("Married");
        divorced = new JRadioButton("Divorced");
        widowed = new JRadioButton("Widowed");

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(divorced);
        maritalStatusGroup.add(widowed);
        maritalStatusGroup.add(single);

        single.setBounds(300, 200, 75, 30);
        married.setBounds(375, 200, 75, 30);
        divorced.setBounds(450, 200, 75, 30);
        widowed.setBounds(525, 200, 80, 30);

        married.setBackground(Color.WHITE);
        divorced.setBackground(Color.WHITE);
        widowed.setBackground(Color.WHITE);
        single.setBackground(Color.WHITE);

        add(single);
        add(married);
        add(divorced);
        add(widowed);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(100, 260, 200, 30);
        add(occupation);

        String occupationList[] = {"Unemployed", "Accounting/Finance", "Administrative/Clerical", "Advertising/Public Relations", "Aerospace/Aviation/Defense", "Arts/Entertainment/Publishing", "Banking/Mortgage", "Business Development", "Construction/Facilities", "Consulting", "Customer Service/Call Center", "Education/Training", "Engineering", "Government/Military", "Healthcare", "Hospitality/Travel", "Human Resources", "Information Technology", "Insurance", "Internet/New Media", "Law Enforcement/Security", "Legal", "Manufacturing/Operations", "Marketing", "Non-Profit/Volunteer", "Other", "Pharmaceutical/Biotech", "Project/Program Management", "Real Estate", "Restaurant/Food Service", "Retail", "Sales", "Science/Research", "Telecommunications", "Transportation/Logistics", "Upper Management/Consulting", "Warehouse/Inventory Management"};
        occupations = new JComboBox(occupationList);
        occupations.setFont(new Font("Raleway", Font.BOLD, 12));
        occupations.setBackground(Color.WHITE);
        occupations.setBounds(300, 260, 400, 30);
        add(occupations);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(100, 320, 200, 30);
        add(education);

        String educationList[] = {"High School Diploama/Equivalent", "Some College", "Associates Degree", "Undergraduate Degree", "Master's Degree", "Doctorate", "Other"};
        educations = new JComboBox(educationList);
        educations.setFont(new Font("Raleway", Font.BOLD, 12));
        educations.setBackground(Color.WHITE);
        educations.setBounds(300, 320, 400, 30);
        add(educations);

        JLabel income = new JLabel("Annual Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100, 380, 200, 30);
        add(income);

        String incomeList[] = {"Less than $25,000", "$25,000 - $50,000", "$50,000 - $75,000", "$75,000 - $100,000", "$100,000 - $150,000", "$150,000 or more"};
        incomes = new JComboBox(incomeList);
        incomes.setFont(new Font("Raleway", Font.BOLD, 12));
        incomes.setBackground(Color.WHITE);
        incomes.setBounds(300, 380, 400, 25);
        add(incomes);

        JLabel phoneNumber = new JLabel("Phone Number:");
        phoneNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        phoneNumber.setBounds(100, 440, 200, 30);
        add(phoneNumber);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        phoneNumberTextField.setBounds(300, 440, 400, 25);
        add(phoneNumberTextField);

        JLabel mobileNumber = new JLabel("Mobile Number:");
        mobileNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        mobileNumber.setBounds(100, 500, 200, 30);
        add(mobileNumber);

        mobileNumberTextField = new JTextField();
        mobileNumberTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        mobileNumberTextField.setBounds(300, 500, 400, 25);
        add(mobileNumberTextField);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 560, 200, 30);
        add(accountType);

        checking = new JRadioButton("Checking Account");
        saving = new JRadioButton("Saving Account");

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(checking);
        accountTypeGroup.add(saving);

        checking.setBounds(300, 560, 150, 30);
        checking.setBackground(Color.WHITE);
        saving.setBounds(450, 560, 200, 30);
        saving.setBackground(Color.WHITE);

        add(checking);
        add(saving);

        JLabel creditCard = new JLabel("Applying for Credit Card?:");
        creditCard.setFont(new Font("Raleway", Font.BOLD, 18));
        creditCard.setBounds(100, 620, 400, 30);
        add(creditCard);

        creditCardYes = new JRadioButton("Yes");
        creditCardNo = new JRadioButton("No");

        ButtonGroup creditCardGroup = new ButtonGroup();
        creditCardGroup.add(creditCardYes);
        creditCardGroup.add(creditCardNo);

        creditCardYes.setBounds(375, 620, 75, 30);
        creditCardYes.setBackground(Color.WHITE);

        creditCardNo.setBounds(450, 620, 75, 30);
        creditCardNo.setBackground(Color.WHITE);

        add(creditCardYes);
        add(creditCardNo);

        previous = new JButton("Previous");
        previous.setBackground(Color.BLACK);
        previous.setForeground(Color.WHITE);
        previous.setFont(new Font("Raleway", Font.BOLD, 14));
        previous.setBounds(100, 680, 100, 30);
        previous.addActionListener(this);
        add(previous);

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




        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (other.isSelected()){
            gender = "Other";
        } else if (preferNotDisclose.isSelected()){
            gender = "Prefer Not to Disclose";
        }

        String maritalStatus = null;
        if (single.isSelected()){
            maritalStatus = "Single";
        } else if (married.isSelected()){
            maritalStatus = "Married";
        } else if (divorced.isSelected()){
            maritalStatus = "Divorced";
        } else if (widowed.isSelected()){
            maritalStatus = "Widowed";
        }

        String occupation = (String) occupations.getSelectedItem();
        String education = (String) educations.getSelectedItem();
        String income = (String) incomes.getSelectedItem();
        String phoneNumber = phoneNumberTextField.getText();
        String mobileNumber = mobileNumberTextField.getText();

        String accountType = null;
        if (checking.isSelected()){
            accountType = "Checking";
        } else if (saving.isSelected()){
            accountType = "Saving";
        }

        String applyingCreditCard = null;
        if (creditCardYes.isSelected()){
            applyingCreditCard = "Yes";
        } else if (creditCardNo.isSelected()){
            applyingCreditCard = "No"; 
        }

        try {
            if (gender == null){
                JOptionPane.showMessageDialog(null, "Gender is required");
            } else if (maritalStatus == null){
                JOptionPane.showMessageDialog(null, "Marital Status is required");
            } else if (phoneNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Phone Number is required");
            } else if (mobileNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Mobile Number is required");
            } else if (accountType == null){
                JOptionPane.showMessageDialog(null, "Account Type is required");
            } else if (applyingCreditCard == null){
                JOptionPane.showMessageDialog(null, "Credit Card question is required");
            } else {
                System.out.println(firstName);
                setVisible(false);
                // new SignupOne(formNumber, firstName, lastName, dob, address, city, state, zipcode, email, confirmEmail).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    public static void main(String args[]){
        new SignupTwo("", "", "", "", "", "", "", "", "","");
    }
}


//     else if (ae.getSource() == previous){
//         setVisible(false);
//         SignupOne().setVisible(true);
//     }

// public void actionPerformed(ActionEvent ae){
//     if (ae.getSource() == clear){
//         usernameTextField.setText("");
//         passwordTextField.setText("");
//     } else if (ae.getSource() == login) {

//     } else if (ae.getSource() == signup){
//         setVisible(false);
//         new SignupOne().setVisible(true);
//     }
// }