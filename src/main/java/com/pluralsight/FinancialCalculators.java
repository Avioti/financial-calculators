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

    System.out.println("Mortage(M/1), FutureValue(Fv/2), PresentValue(Pv/3)");

    String calcChoice = scanner.next();

    if (calcChoice.equalsIgnoreCase("Mortgage") || calcChoice.equalsIgnoreCase("M") || calcChoice.equalsIgnoreCase("1")){
        mortgageCalc();
    }
    else if (calcChoice.equalsIgnoreCase("FutureValue") || calcChoice.equalsIgnoreCase("Fv") || calcChoice.equalsIgnoreCase("2")){
        futureValueCalc();
    }
    else if (calcChoice.equalsIgnoreCase("PresentValue") || calcChoice.equalsIgnoreCase("Pv") || calcChoice.equalsIgnoreCase("3")){
        presentValueCalc();
    } else {
        System.out.println("System Error!!!, RUN AGAIN TO PICK ONE OF THE AVAILABLE OPTIONS");
    }
}


    public static void mortgageCalc(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the Total amount of the loan: ");


        double Principal = scanner.nextDouble();


        System.out.println("What is the Interest Rate: ");
        double Interest_rate = scanner.nextDouble();
        if (Interest_rate != 0){
            Interest_rate = interestConversion(Interest_rate);
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
        double Annual_interest = interestConversion(Interest_rate);

        System.out.println("How many years will this deposit gain interest: ");
        double Owned_length = scanner.nextDouble();

        double Future_value = Initial_deposit * Math.pow(1 + (Annual_interest / 365), (365 * Owned_length));
        double Total_interest = Future_value - Initial_deposit;
        System.out.printf("The future value of this cd is %.2f" + " and the Total interest paid is %.2f", Future_value , Total_interest);
    }



    public static void presentValueCalc(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the monthly payout?");

        double Monthly_payout = scanner.nextDouble();

        System.out.println("What is the expected interest rate?");
        double Expected_rate = scanner.nextDouble();
        double Interest_rate = interestConversion(Expected_rate) / 12;

        System.out.println("How many years to payout?");
        double  Years = scanner.nextDouble() * 12;

        double Present_value = Monthly_payout * (1 - Math.pow(1 + Interest_rate, -Years)) / Interest_rate;

        System.out.printf("To fund an annuity that pays $%.2f monthly for %.2f years and earns an expected " + Expected_rate + "%% interest, you would need to invest %.2f today", Monthly_payout, Years, Present_value);
    }



    public static double interestConversion(double x){
        return x / 100;
    }


}
