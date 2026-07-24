// package OOPs;

/**
 * Topic: Object-Oriented Programming (OOP)
 * Problem: Abstraction and Inheritance
 * 
 * Description: 
 * Demonstrates the concept of Abstraction using an abstract class 'Animal' 
 * and concrete subclasses 'Horse' and 'Hen'.
 * 
 * Intuition:
 * Abstract classes cannot be instantiated. They serve as a template for other classes.
 * They can contain abstract methods (which subclasses MUST implement) and concrete methods.
 * Abstract classes can also have constructors, which are called when a subclass object is instantiated.
 * 
 * Complexity: O(1) Time and Space for simple instantiation and method calls.
 */
public class AbstractionBasics {
    public static void main(String[] args) {
        System.out.println("Creating a Horse:");
        Horse h1 = new Horse();
        h1.eat();
        h1.walk();

        System.out.println("\nCreating a Hen:");
        Hen h2 = new Hen();
        h2.eat();
        h2.walk();
    }
}

abstract class Animal {
    // Constructor of abstract class
    Animal() {
        System.out.println("Animal Constructor Called!");
    }

    void eat() {
        System.out.println("Eating!!!");
    }

    // Abstract method must be implemented by subclasses
    abstract void walk(); 
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse Constructor Called!");
    }

    @Override
    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Hen extends Animal {
    Hen() {
        System.out.println("Hen Constructor Called!");
    }

    @Override
    void walk() {
        System.out.println("Walks on 2 legs");
    }
}
