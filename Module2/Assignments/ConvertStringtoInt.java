package Module2.Assignments;

public class ConvertStringtoInt {
    public static int convertStringToInt(String input) {
        // base case
        if (input.length() == 1) {
            return (input.charAt(0) - '0');
        }
        // Recursion call on small string
        int smallOutput = convertStringToInt(input.substring(1));
        // converting to digit form char using ascii value
        int x = (input.charAt(0) - '0');

        // adding the digit to the desired position
        x = x * (int) Math.pow(10, input.length() - 1) + smallOutput;
        return x;
    }

    public static void main(String[] args) {
        String str = "12345";
        System.out.println(convertStringToInt(str));
    }
}
