package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
mortgageCalc();
    }

    public static void mortgageCalc(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the Total amount of the loan: ");
        double Principal = scanner.nextDouble();
        System.out.println("What is the Interest Rate: ");
        double Interest_rate = scanner.nextDouble();
        if (Interest_rate != 0){
            Interest_rate = Interest_rate / 100;
        }
        double Monthly_Interest = Interest_rate / 12;
        System.out.println("Estimated Length of loan? ");
        double Loan_length = scanner.nextDouble();
        System.out.println("Years or Months");
        String Length_amount = scanner.next();
        if (Length_amount.equalsIgnoreCase("Years" ) || Length_amount.equalsIgnoreCase("Year") || Length_amount.equalsIgnoreCase("Y" )){
            Loan_length = 12 * Loan_length;

        }


        double Monthly_payment = Principal * (Monthly_Interest * Math.pow(1 + Monthly_Interest, Loan_length)) / (Math.pow(1 + Monthly_Interest, Loan_length) - 1);
        double Total_interest = (Monthly_payment * Loan_length) - Principal;
        System.out.printf("Your monthly payment is: %.2f " + " With a total interest paid of %.2f " ,Monthly_payment , Total_interest);




    }

    public static void futureValueCalc(){

    }

    public static void presentValueCalc(){

    }
}
