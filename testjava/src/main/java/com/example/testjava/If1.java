package com.example.testjava;

public class If1 {
    public static void main(String args[]) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        if (y == 0) {
            System.out.println("Program Exit: Divided by zero!");
            System.exit(0);
        }
        System.out.println("args[0]/args[1] =" + x/y);
    }
}
