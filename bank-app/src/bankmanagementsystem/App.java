package bankmanagementsystem;

// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");
//     }
// }

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Prompt user for input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your annual income: ");
        double income = scanner.nextDouble();
        System.out.print("Are you employed? (Y/N): ");
        boolean employed = scanner.next().equalsIgnoreCase("Y");
        System.out.print("Do you own property? (Y/N): ");
        boolean ownsProperty = scanner.next().equalsIgnoreCase("Y");

        // Calculate debt-to-income ratio based on employment status and property ownership
        double debtToIncomeRatio = calculateDebtToIncomeRatio(employed, ownsProperty, income);

        // Calculate credit score and credit limit
        int creditScore = calculateCreditScore(income, debtToIncomeRatio, employed);
        double creditLimit = calculateCreditLimit(creditScore, income, employed, ownsProperty);

        // Print credit score and credit limit
        System.out.println("Credit score: " + creditScore);
        System.out.println("Credit limit: " + creditLimit);

        scanner.close();
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
}
