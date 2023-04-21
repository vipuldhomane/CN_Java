package CN_Java.inputsinjava;

import java.util.Scanner;

public class Typecasting {
    public static void main(String[] args) {
        /*
         * Typecasting
         * DATA TYPE DEFAULT VALUE DEFAULT SIZE
         * char '\0' (null character) 2 bytes
         * byte 0 1 byte
         * short 0 2 bytes
         * int 0 4 bytes
         * long 0L 8 bytes
         * Float 0.0f 4 bytes
         * Double 0.0d 8 bytes
         * Boolean false Not specified
         * 
         * There are two types of typecasting
         * implicit :- when smaller data type gets converted into bigger datatype
         * there is no data loss happening Ex. int to short
         * explicit :- when bigger data type want to be converted into the smaller
         * data type then we need to force typecasting.
         * by doing this there will be some data loss.
         */
        Scanner sc = new Scanner(System.in);
        int i = 100;
        System.out.println(i);
        double d = i;
        System.out.println(d);
        float f = i;
        System.out.println(f);
        float ff = (float) d;
        System.out.println(ff);

    }
}
