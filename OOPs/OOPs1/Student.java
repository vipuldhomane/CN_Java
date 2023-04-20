package OOPs.OOPs1;

public class Student {
    // Access modifiers
    // By default AM is set default (values can be used in same package but cannot
    // be used outside of package)
    // Private Am means no class can access or modify the value (Getter and Setters
    // will be used)
    // public AM will let anyone set and use value in any class or any package
    String name;
    int rollNumber;
    private int age = 18;
    static final double cgpa = 0.98;
    static int numStudents;
    int Sex;

    public Student(String name, int age, int rollNumber, int Sex) {
        // passing values at time of setting is mandatory
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.Sex = Sex;

    }

    // Getters and Setters
    public void setAge(int age) {
        if (age < 0) {
            return;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    // Constructor
    // Default
    public Student() {
        // nothing needs to be passed here
    }
    // Here We have overloaded the same constructors with multiple input types

    // Mandatory to set values

    // Student(String name, int age) {
    // // this this constructor passing value of roll number is optional
    // this.name = name;
    // this.age = age;
    // this.rollNumber = 00;

    // }

    // Declaring a Function to print the values

    // static void print() {
    // System.out.println(
    // "The name of Student is " + this.name + ", Age is " + this.age + " and Roll
    // number is "
    // + this.rollNumber);
    // }

}
