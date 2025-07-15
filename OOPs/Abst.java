package OOPs;

public class Abst {
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

    abstract void walk(); // Abstract method for walking
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

/*
 * Abstract classes cannot be instantiated directly, but they can have
 * constructors.
 * These constructors are not just for initializing objects; they are also
 * designed
 * to assist the derived (or inherited) classes by providing shared
 * initialization logic
 * or performing tasks common to all subclasses.
 */
