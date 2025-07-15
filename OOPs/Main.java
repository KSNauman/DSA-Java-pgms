package OOPs;

public class Main {
    public static void main(String[] args) {
        // Incorrect syntax example (commented out)
        // student s1 = new student({10,20,30});
        /*
         * The above syntax is not allowed in Java.
         * Arrays in Java require the `new` keyword to allocate memory.
         * Correct syntax: int[] arr = new int[] {10, 20, 30};
         */

        // Create a student object with marks
        student s1 = new student(new int[] { 10, 20, 30 });
        s1.getMarks(); // Display marks of s1

        // Set a password for s1
        s1.setPassword("ABCD");

        // Create a deep copy of s1 into s2
        student s2 = new student(s1);

        // Modify the marks of s1
        s1.marks[0] = 99;

        // Display marks of both s1 and s2 to demonstrate deep copy behavior
        System.out.print("Marks of s1 after modification: ");
        s1.getMarks();

        System.out.print("Marks of s2 (should remain unchanged): ");
        s2.getMarks();
    }
}

class student {
    int[] marks; // Public for demonstration purposes, ideally should be private with getters and
                 // setters
    private String passwd;

    // Copy constructor (deep copy using manual element copying)
    student(student s1) {
        // Create a new array and copy each element from the source object
        this.marks = new int[s1.marks.length];
        for (int i = 0; i < s1.marks.length; i++) {
            this.marks[i] = s1.marks[i]; // Copy each element
        }
    }

    // Constructor to initialize marks array
    student(int[] marks) {
        this.marks = marks; // Direct reference to the provided array
    }

    // Method to set password
    public void setPassword(String passwd) {
        this.passwd = passwd;
    }

    // Method to display marks
    public void getMarks() {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}

/*
 * Explanation of Shallow and Deep Copy:
 * 
 * Shallow Copy:
 * - When creating a new object (e.g., s2) by copying another object (e.g., s1),
 * the reference to the array (marks) is copied, not the array itself.
 * - Any changes made to the array in one object will reflect in the other,
 * as both objects share the same array reference.
 * 
 * Example:
 * s1.marks[0] = 99;
 * s2.getMarks(); // Output will show the modified value (99).
 * 
 * Deep Copy:
 * - In a deep copy, a new array is created, and each element of the original
 * array is copied individually.
 * - This ensures that changes to the array in one object do not affect the
 * other.
 * 
 * Implementation of Deep Copy:
 * Replace the shallow copy logic in the copy constructor with:
 * 
 * student(student s1) {
 * this.marks = new int[s1.marks.length];
 * for (int i = 0; i < s1.marks.length; i++) {
 * this.marks[i] = s1.marks[i]; // Copy each element
 * }
 * }
 * 
 * Now, changes to `s1.marks` will not affect `s2.marks` and vice versa.
 */
