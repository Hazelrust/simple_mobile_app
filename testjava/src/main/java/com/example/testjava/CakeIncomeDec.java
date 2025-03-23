package com.example.testjava;

import java.util.Scanner;

public class CakeIncomeDec {
    static Scanner console = new Scanner(System.in);
    public static void main (String [] args) {
        float sum, income, monthlyAverage;
        sum = 0.0f;
        for (int i=0; i < 31; i++) {
            System.out.print("Enter income for day " + (i + 1) + " : ");
            income = console.nextFloat();
            sum += income;
        }
        monthlyAverage = sum / 31.0f;
    }
}
