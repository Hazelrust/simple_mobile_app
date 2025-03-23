package com.example.testjava;

import java.util.Scanner;

public class CakeIncomeArray2 {
    static Scanner console = new Scanner(System.in);
    public static void main (String args[]) {
        float[ ] income;
        float maxIncome, monthlyAverage, sum;
        String message;
        int dayOfMaxIncome, month, noOfDay, count = 0;
        sum=0.0f;
        System.out.print("Month number: ");
        month = console.nextInt();
        if (month == 2)
            noOfDay=28;
        else if (month==4 || month==6 || month==9 || month==11)
            noOfDay=30;
        else
            noOfDay=31;
        income = new float[noOfDay];
        maxIncome = income[0];
        dayOfMaxIncome = 1;
        for (int i=0; i < income.length; i++){
            System.out.println("Enter income for day " + (i+1) + ": ");
            income[i] = console.nextFloat();
            sum += income[i];
        }
        for (int i=1; i < income.length; i++) {
            if (income[i] >= maxIncome) {
                maxIncome = income[i];
                dayOfMaxIncome = i+1;
            }
        }
        monthlyAverage = sum / income.length;
        message = "Days more than average: ";
        for (int i=0; i<income.length; i++) {
            if (income[i] > monthlyAverage) {
                message = message + (i+1) + " ";
                count++;
            }
        }
        System.out.println("Max income: " + maxIncome);
        System.out.println("The day of max income: " + dayOfMaxIncome);
        System.out.println("Monthly Average: " + monthlyAverage);
        System.out.println(message);
        System.out.println("Number of days more that average: " + count);
    }
}
