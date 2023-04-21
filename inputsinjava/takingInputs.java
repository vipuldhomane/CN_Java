package CN_Java.inputsinjava;

import java.util.Scanner;

import Loops.for_loops.print_100times;

public class takingInputs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking character as Input
        /*
         * There is no direct way to take character as input in java
         * instead first we create a string and then we use .charAT(0)
         * method to extract the first element in the string
         */
        char a = sc.next().charAt(0);
        System.out.println(a);
    }
}
