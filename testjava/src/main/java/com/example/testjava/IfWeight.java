package com.example.testjava;
//Program IfWeight.java
import java.util.Scanner;
public class IfWeight {
    public static void main (String [ ] args) {
        Scanner console = new Scanner(System.in);
        int gender;
        float height, weight;
        Weight weightCalculator = new Weight( );
        System.out.print("Enter '1' for Male or '2' for female : "); gender = console.nextInt();
        if ((gender == 1) || (gender ==2)) {
            System.out.print("Please enter your height : ");
            height = console.nextFloat();
            weightCalculator.setGender(gender);
            weightCalculator.setHeight(height);
            weight = weightCalculator.calculate();
            System.out.print("Your weight should not more than "+
                    weight + " kgs.");
        } else System.out.print("Invalid gender.");
    }
}
class Weight{
    private int gender;
    private float height;
    public void setGender(int gender) {
        this.gender = gender;
    }
    public void setHeight(float height) { this.height = height; }

public float calculate( ) {
    float weight;
    if (gender == 1)
        weight = height-100;
    else
        weight = height-110;
    return(weight);
}
}