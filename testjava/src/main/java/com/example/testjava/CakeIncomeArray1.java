package com.example.testjava;

import java.util.Scanner;

public class CakeIncomeArray1 {
    static Scanner console = new Scanner(System.in);
    public static void main (String args[]) {
        float[] income = new float[3];
        float maxIncome, monthlyAverage, sum;
        String message;
        int dayOfMaxIncome, count = 0;
        sum=0.0f;
        maxIncome = income[0];
        dayOfMaxIncome = 1;
        for (int i=0; i < income.length; i++) {
            System.out.print("Enter income for day " + (i+1) + ": ");
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
        for (int i=0; i < income.length; i++) {
            if (income[i] > monthlyAverage) {
                message = message + (i+1) + " ";
                count++;
            }
        }
        System.out.println("Max income: " + maxIncome);
        System.out.println("The day of max income:"+ dayOfMaxIncome);
        System.out.println("Monthly Average: "+ monthlyAverage);
        System.out.println(message);
        System.out.println("Number of days more that average: " + count);
    }
}
