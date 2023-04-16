package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    long random;
    JTextField occupationTextField, educationTextField, incomeTextField, phoneNumberTextField, mobileNumberTextField;
    JButton next;
    JDateChooser dateChooser;

    SignupTwo(){

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

        JLabel gender = new JLabel("Gender*:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 140, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        JRadioButton preferNotDisclose = new JRadioButton("Prefer Not To Disclose");

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

        JLabel maritalStatus = new JLabel("Marital Status*:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        maritalStatus.setBounds(100, 200, 200, 30);
        add(maritalStatus);

        JRadioButton married = new JRadioButton("Married");
        JRadioButton divorced = new JRadioButton("Divorced");
        JRadioButton widowed = new JRadioButton("Widowed");
        JRadioButton single = new JRadioButton("Single");

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

        JLabel occupation = new JLabel("Occupation*:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(100, 260, 200, 30);
        add(occupation);

        String occupationList[] = {"Accounting/Finance", "Administrative/Clerical", "Advertising/Public Relations", "Aerospace/Aviation/Defense", "Arts/Entertainment/Publishing", "Banking/Mortgage", "Business Development", "Construction/Facilities", "Consulting", "Customer Service/Call Center", "Education/Training", "Engineering", "Government/Military", "Healthcare", "Hospitality/Travel", "Human Resources", "Information Technology", "Insurance", "Internet/New Media", "Law Enforcement/Security", "Legal", "Manufacturing/Operations", "Marketing", "Non-Profit/Volunteer", "Other", "Pharmaceutical/Biotech", "Project/Program Management", "Real Estate", "Restaurant/Food Service", "Retail", "Sales", "Science/Research", "Telecommunications", "Transportation/Logistics", "Upper Management/Consulting", "Warehouse/Inventory Management"};
        JComboBox occupations = new JComboBox(occupationList);
        occupations.setFont(new Font("Raleway", Font.BOLD, 12));
        occupations.setBackground(Color.WHITE);
        occupations.setBounds(300, 260, 400, 30);
        add(occupations);

        JLabel education = new JLabel("Education*:");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setBounds(100, 320, 200, 30);
        add(education);

        String educationList[] = {"High School Diploama/Equivalent", "Some College", "Associates Degree", "Undergraduate Degree", "Master's Degree", "Doctorate", "Other"};
        JComboBox educations = new JComboBox(educationList);
        educations.setFont(new Font("Raleway", Font.BOLD, 12));
        educations.setBackground(Color.WHITE);
        educations.setBounds(300, 320, 400, 30);
        add(educations);

        JLabel income = new JLabel("Annual Income*:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100, 380, 200, 30);
        add(income);

        String incomeList[] = {"Less than $25,000", "$25,000 - $50,000", "$50,000 - $75,000", "$75,000 - $100,000", "$100,000 - $150,000", "$150,000 or more"};
        JComboBox incomes = new JComboBox(incomeList);
        incomes.setFont(new Font("Raleway", Font.BOLD, 12));
        incomes.setBackground(Color.WHITE);
        incomes.setBounds(300, 380, 400, 25);
        add(incomes);

        incomeTextField = new JTextField();
        incomeTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        incomeTextField.setBounds(300, 380, 400, 25);
        add(incomeTextField);

        JLabel phoneNumber = new JLabel("Phone Number*:");
        phoneNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        phoneNumber.setBounds(100, 440, 200, 30);
        add(phoneNumber);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        phoneNumberTextField.setBounds(300, 440, 400, 25);
        add(phoneNumberTextField);

        JLabel mobileNumber = new JLabel("Mobile Number*:");
        mobileNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        mobileNumber.setBounds(100, 500, 200, 30);
        add(mobileNumber);

        mobileNumberTextField = new JTextField();
        mobileNumberTextField.setFont(new Font("Raleway", Font.BOLD, 12));
        mobileNumberTextField.setBounds(300, 500, 400, 25);
        add(mobileNumberTextField);

        JLabel accountType = new JLabel("Account Type*:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 560, 200, 30);
        add(accountType);

        JRadioButton checking = new JRadioButton("Checking Account");
        JRadioButton saving = new JRadioButton("Saving Account");

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(checking);
        accountTypeGroup.add(saving);

        checking.setBounds(300, 560, 150, 30);
        checking.setBackground(Color.WHITE);
        saving.setBounds(450, 560, 200, 30);
        saving.setBackground(Color.WHITE);

        add(checking);
        add(saving);

        JLabel creditCard = new JLabel("Applying for Credit Card?*:");
        creditCard.setFont(new Font("Raleway", Font.BOLD, 18));
        creditCard.setBounds(100, 620, 400, 30);
        add(creditCard);

        JRadioButton creditCardYes = new JRadioButton("Yes");
        JRadioButton creditCardNo = new JRadioButton("No");

        ButtonGroup creditCardGroup = new ButtonGroup();
        creditCardGroup.add(creditCardYes);
        creditCardGroup.add(creditCardNo);

        creditCardYes.setBounds(375, 620, 75, 30);
        creditCardYes.setBackground(Color.WHITE);

        creditCardNo.setBounds(450, 620, 75, 30);
        creditCardNo.setBackground(Color.WHITE);

        add(creditCardYes);
        add(creditCardNo);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String occupation = occupationTextField.getText();
        String education = educationTextField.getText();
        String income = incomeTextField.getText();
        String phone = phoneNumberTextField.getText();
        String mobile = mobileNumberTextField.getText();

        try {
            if (occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation is required");
            } else if (education.equals("")){
                JOptionPane.showMessageDialog(null, "Education is required");
            } else if (income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is required");
            } else if (phone.equals("")){
                JOptionPane.showMessageDialog(null,"Phone number is required");
            } else if (mobile.equals("")){
                JOptionPane.showMessageDialog(null, "Mobile number is required");
            } else {

            }

            // if (firstName.equals("")){
            //     JOptionPane.showMessageDialog(null, "First Name is Required");
            // }
            // else if (lastName.equals("")){
            //     JOptionPane.showMessageDialog(null, "Last Name is Required");
            // }
            // else if (dob.equals("")){
            //     JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            // }
            // else if (address.equals("")){
            //     JOptionPane.showMessageDialog(null, "Address is Required");
            // }
            // else if (city.equals("")){
            //     JOptionPane.showMessageDialog(null, "City is Required");
            // }
            // else if (state.equals("")){
            //     JOptionPane.showMessageDialog(null, "State is Required");
            // }
            // else if (zipcode.equals("")){
            //     JOptionPane.showMessageDialog(null, "Zipcode is Required");
            // }
            // else if (email.equals("")){
            //     JOptionPane.showMessageDialog(null, "Email is Required");
            // }
            // else if (!email.contains("@")){
            //     JOptionPane.showMessageDialog(null, "Please enter a valid email");
            // }
            // else if (confirmEmail.equals("")){
            //     JOptionPane.showMessageDialog(null, "Confirmation Email is Required");
            // }
            // else if (!email.equals(confirmEmail)){
            //     JOptionPane.showMessageDialog(null, "Emails are not the same, please check spelling");
            // }
            // else {
            //     System.out.println(formNumber);
            //     Conn c = new Conn();
            //     String query = "insert into signup values('"+formNumber+"','"+firstName+"','"+lastName+"','"+dob+"','"+address+"', '"+city+"','"+state+"','"+zipcode+"','"+email+"')";
            //     c.s.executeUpdate(query);
            // }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo();
    }
}