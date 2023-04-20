package JavaStrings;

public class ReverseString {
    public static String reverseString(String str) {
        String revString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revString += str.charAt(i);
        }
        return revString;
    }

    public static String revString1(String str) {
        String revString = "";
        for (int i = 0; i < str.length(); i++) {
            revString = str.charAt(i) + revString;
        }
        return revString;
    }

    public static void main(String[] args) {
        String str = "Hi this is Vipul Dhomane";
        // System.out.println(reverseString(str));
        System.out.println(revString1(str));
    }

}
