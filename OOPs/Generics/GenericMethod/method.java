package OOPs.Generics.GenericMethod;

public class method {
    public static <T> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Boolean arr[] = { true, false, false, true, true };
        printArray(arr);
    }
}
