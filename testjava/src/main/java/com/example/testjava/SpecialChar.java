package com.example.testjava;

public class SpecialChar {
    public static void main(String[] args) {

        String s = "#hello class LS478$%!";

        // Count  special characters
        int count = 0;

        // Iterating through the string to check special characters
        if (s.length() > 8) System.out.println("long string");
        for (int i = 0; i < s.length(); i++) {
            // If character is not a letter, digit, or space, it's a special character
            if (!Character.isLetterOrDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                count++; // Increment count             }
            }
        }
            // Display the result
            if (count > 0) {
                System.out.println("Special characters found: " + count);
            } else {
                System.out.println("No Special Characters found.");
            }
        }
    }

