/**
 * Topic: Bit Manipulation
 * Problem: Check if a number is Even or Odd
 * 
 * Description: 
 * Determine whether a given integer is even or odd using bit manipulation.
 * 
 * Intuition:
 * The least significant bit (LSB) of any odd number is always 1, 
 * and for any even number, it is 0. By performing a bitwise AND operation 
 * with 1 (the bitmask), we can isolate the LSB. If the result is 1, it's odd. 
 * If 0, it's even.
 * Note: `(n & bitMask) == 0` requires parentheses because `==` has higher precedence than `&`.
 * 
 * Complexity: O(1) Time, O(1) Space.
 */
public class EvenOrOdd {
    public static void main(String[] args) {
        int n = 9;
        int bitMask = 1;
        
        if ((n & bitMask) == 0) {
            System.out.println(n + " is Even");
        } else {
            System.out.println(n + " is Odd");
        }
    }
}