// package OOPs;

/**
 * Topic: Object-Oriented Programming (OOP)
 * Problem: Deep Copy vs Shallow Copy
 * 
 * Description: 
 * Demonstrates the difference between Shallow Copy and Deep Copy using a custom Copy Constructor.
 * 
 * Intuition:
 * - Shallow Copy: Copies references. If the original object contains a reference to an array/object, 
 *   the copied object will point to the SAME array/object. Modifying one affects the other.
 * - Deep Copy: Creates new memory allocations. Elements from the original array/object are explicitly 
 *   copied into the new one. Modifying one does NOT affect the other.
 * 
 * Complexity: O(N) Time for deep copying an array of size N, O(N) Space.
 */
public class OOPBasics {
    public static void main(String[] args) {
        // Create a student object with marks
        Student s1 = new Student(new int[] { 10, 20, 30 });
        System.out.print("Marks of s1 initially: ");
        s1.getMarks();

        // Create a deep copy of s1 into s2
        Student s2 = new Student(s1);

        // Modify the marks of s1
        s1.marks[0] = 99;

        // Display marks of both s1 and s2 to demonstrate deep copy behavior
        System.out.print("Marks of s1 after modification: ");
        s1.getMarks();

        System.out.print("Marks of s2 (should remain unchanged due to deep copy): ");
        s2.getMarks();
    }
}

class Student {
    int[] marks; 
    private String password;

    // Deep Copy Constructor
    Student(Student s1) {
        // Create a new array and copy each element manually
        this.marks = new int[s1.marks.length];
        for (int i = 0; i < s1.marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    // Constructor to initialize marks array
    Student(int[] marks) {
        this.marks = marks;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for marks
    public void getMarks() {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }
}
