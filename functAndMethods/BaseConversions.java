// package functAndMethods;

import java.util.Scanner;

/**
 * Topic: Functions and Methods
 * Problem: Base Conversions (Binary to Decimal, Decimal to Binary)
 * 
 * Description: 
 * Perform mathematical conversions between Binary (Base 2) and Decimal (Base 10) number systems.
 * 
 * Intuition:
 * - Binary to Decimal: Extract the last digit of the binary number (using % 10) and multiply it 
 *   by 2^power, where power starts at 0 and increments with each digit.
 * - Decimal to Binary: Extract the remainder of the decimal number when divided by 2 (using % 2),
 *   and place it at the corresponding 10^power position to form the binary number.
 * 
 * Complexity: O(log N) Time for both operations (where N is the input number), O(1) Space.
 */
public class BaseConversions {
    
    // Convert Binary to Decimal
    public static int binaryToDecimal(int bin) {
        int dec = 0, pow = 0;
        int ld = 0;
        while (bin > 0) {
            ld = bin % 10;
            bin /= 10;
            dec = dec + ld * (int) Math.pow(2, pow);
            pow++;
        }
        return dec;
    }
 
    // Convert Decimal to Binary
    public static int decimalToBinary(int n) {
        int rem, bin = 0, pow = 0;
        while (n > 0) {
            rem = n % 2;
            n /= 2;
            bin = bin + rem * ((int) Math.pow(10, pow));
            pow++;
        }
        return bin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter 1 for Bin->Dec, 2 for Dec->Bin:");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            System.out.println("Enter the Binary number:");
            int bin = sc.nextInt();
            System.out.println("Decimal is: " + binaryToDecimal(bin));
        } else if (choice == 2) {
            System.out.println("Enter the Decimal number:");
            int dec = sc.nextInt();
            System.out.println("Binary is: " + decimalToBinary(dec));
        } else {
            System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
