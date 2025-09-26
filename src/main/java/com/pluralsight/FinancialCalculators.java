package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
calcChoice();
    }
public static void calcChoice(){
        Scanner scanner = new Scanner(System.in);
    System.out.println("Which calculator will you like today?");
    System.out.println("Mortage(M/1), FutureValue(Fv/2)");
    String calcChoice = scanner.next();
    if (calcChoice.equalsIgnoreCase("Mortgage") || calcChoice.equalsIgnoreCase("M") || calcChoice.equalsIgnoreCase("1")){
        mortgageCalc();
    } else if (calcChoice.equalsIgnoreCase("FutureValue") || calcChoice.equalsIgnoreCase("Fv") || calcChoice.equalsIgnoreCase("2")){
        futureValueCalc();
    }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter deposit amount: ");
        double Initial_deposit = scanner.nextDouble();
        System.out.println("What is the interest rate: ");
        double Interest_rate = scanner.nextDouble();
        double Annual_interest = Interest_rate / 100;
        System.out.println("How many years will this deposit gain interest: ");
        double Owned_length = scanner.nextDouble();

        double Future_value = Initial_deposit * Math.pow(1 + (Annual_interest / 365), (365 * Owned_length));
        double Total_interest = Future_value - Initial_deposit;
        System.out.printf("The future value of this cd is %.2f" + " and the Total interest paid is %.2f", Future_value , Total_interest);
    }

    public static void presentValueCalc(){

    }
}
