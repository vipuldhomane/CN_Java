package Module3.Recursion3;

public class PrintPhoneKeypad {
    private static String getOptions(int digit) {
        if (digit == 2) {
            return "abc";
        }
        if (digit == 3) {
            return "def";
        }
        if (digit == 4) {
            return "ghi";
        }
        if (digit == 5) {
            return "jkl";
        }
        if (digit == 6) {
            return "mno";
        }
        if (digit == 7) {
            return "pqrs";
        }
        if (digit == 8) {
            return "tuv";
        }
        if (digit == 9) {
            return "wxyz";
        }
        return "";
    }

    public static void printKeypadCombinations(int input, String asf) {
        // Base Case
        if (input == 0) {
            System.out.println(asf);
            return;
        }
        int lastDigit = input % 10;
        int smallInput = input / 10;
        String lastDigitsOptions = getOptions(lastDigit);
        for (int i = 0; i < lastDigitsOptions.length(); i++) {
            printKeypadCombinations(smallInput, lastDigitsOptions.charAt(i) + asf);
        }
    }

    public static void main(String[] args) {
        printKeypadCombinations(234, "");
    }
}
