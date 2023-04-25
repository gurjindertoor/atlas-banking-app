package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ApplyCreditCard extends JFrame implements ActionListener{
    boolean employed, ownsProperty;
    JTextField amount;
    JButton accept, back;
    String username, passwordString;
    int income;

    ApplyCreditCard(String username, String passwordString){
        this.username = username;
        this.passwordString = passwordString;
        setLayout(null);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from signup where username = '"+username+"' and password = '"+passwordString+"'");

            while (rs.next()){
                if (rs.getString("occupation").equals("Unemployed")) {
                    employed = false;
                } else {
                    employed = true;
                }

                if (rs.getString("ownOrRent").equals("Own Property")) {
                    ownsProperty = true;
                } else {
                    ownsProperty = false;
                }
    
                if (rs.getString("income").equals("Less than $25,000")){
                    income = 24999;
                } else if (rs.getString("income").equals("$25,000 - $50,000")) {
                    income = 49999;
                } else if (rs.getString("income").equals("$50,000 - $75,000")) {
                    income = 74999;
                } else if (rs.getString("income").equals("$75,000 - $100,000")) {
                    income = 99999;
                } else if (rs.getString("income").equals("100,000 - $150,000")) {
                    income = 149999;
                } else {
                    income = 150000;
                }

                double debtToIncomeRatio = calculateDebtToIncomeRatio(employed, ownsProperty, income);
                int creditScore = calculateCreditScore(income, debtToIncomeRatio, employed);
                double creditLimit = calculateCreditLimit(creditScore, income, employed, ownsProperty);
                double apr = calculateAPR(creditScore);

                JLabel text = new JLabel("Apply for Credit Card");
                text.setFont(new Font("System", Font.BOLD, 16));
                text.setForeground(Color.WHITE);
                text.setBounds(260, 300, 400, 20);
                image.add(text);
        
                JLabel creditLimitLabel = new JLabel("Your credit limit is: $" + String.format("%.2f", Math.ceil(creditLimit)));
                creditLimitLabel.setFont(new Font("System", Font.BOLD, 12));
                creditLimitLabel.setForeground(Color.WHITE);
                creditLimitLabel.setBounds(235, 350, 400, 20);
                image.add(creditLimitLabel);

                JLabel aprLabel = new JLabel("Your APR is: " + String.format("%.2f", apr * 100) + "%");
                aprLabel.setFont(new Font("System", Font.BOLD, 12));
                aprLabel.setForeground(Color.WHITE);
                aprLabel.setBounds(235, 375, 400, 20);
                image.add(aprLabel);
            }
        } catch (Exception e){
            System.out.println(e);
        }

        accept = new JButton("Accept Card");
        accept.setBounds(352, 485, 150, 30);
        accept.addActionListener(this);
        image.add(accept);

        back = new JButton("Back");
        back.setBounds(352, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setResizable(false);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public static double calculateDebtToIncomeRatio(boolean employed, boolean ownsProperty, double income) {
        double monthlyDebt = 0;

        // Assume monthly debt is 25% of income if unemployed or if renting
        if (!employed || !ownsProperty) {
            monthlyDebt = income * 0.25;
        }

        return monthlyDebt / (income / 12);
    }

    public static int calculateCreditScore(double income, double debtToIncomeRatio, boolean employed) {
        int creditScore = 0;

        // Calculate credit score based on income
        if (income < 20000) {
            creditScore = (int) (Math.random() * (650 - 550) + 550);
        } else if (income < 50000) {
            creditScore = (int) (Math.random() * (750 - 650) + 650);
        } else if (income < 100000) {
            creditScore = (int) (Math.random() * (800 - 750) + 750);
        } else {
            creditScore = (int) (Math.random() * (850 - 800) + 800);
        }

        // Adjust credit score based on debt-to-income ratio
        if (debtToIncomeRatio >= 0.3) {
            creditScore -= (int) (Math.random() * (50 - 25) + 25);
        } else if (debtToIncomeRatio >= 0.2) {
            creditScore -= (int) (Math.random() * (25 - 10) + 10);
        }

        // Adjust credit score based on employment status
        if (!employed) {
            creditScore -= (int) (Math.random() * (100 - 50) + 50);
        }

        return creditScore;
    }

  public static double calculateCreditLimit(int creditScore, double income, boolean employed, boolean ownsProperty) {
      double creditLimit = 0;
  
      // Calculate credit limit based on credit score and income
      if (creditScore < 550) {
          creditLimit = 0;
      } else if (creditScore < 650) {
          creditLimit = income * 0.1;
      } else if (creditScore < 750) {
          creditLimit = income * 0.2;
      } else if (creditScore < 800) {
          creditLimit = income * 0.3;
      } else {
          creditLimit = income * 0.4;
      }
  
      // Adjust credit limit based on employment status
      if (!employed) {
          creditLimit *= 0.5;
      }
  
      // Adjust credit limit based on property ownership
      if (!ownsProperty) {
          creditLimit *= 0.9;
      }
  
      return creditLimit;
  }

  public static double calculateAPR(int creditScore) {
    double apr = 0.0;

    if (creditScore >= 800) {
        apr = 0.010;
    } else if (creditScore >= 750) {
        apr = 0.015;
    } else if (creditScore >= 700) {
        apr = 0.020;
    } else if (creditScore >= 650) {
        apr = 0.025;
    } else if (creditScore >= 600) {
        apr = 0.030;
    } else {
        apr = 0.035;
    }

    return apr;
}

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            dispose();
            new Transactions(username, passwordString);
        } else {
            JOptionPane.showMessageDialog(null, "Credit card has been accepted.");
            dispose();
            new Transactions(username, passwordString);
        }
    }

    public static void main(String args[]){
        new ApplyCreditCard("","");
    }
}