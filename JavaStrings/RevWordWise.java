package JavaStrings;

public class RevWordWise {
    public static String reverseString(String str) {
        String revString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revString += str.charAt(i);
        }
        return revString;
    }

    public static String revWordWise(String input) {
        // Reversing Original String
        String str = reverseString(input);
        String ans = "";
        int currentWordStart = 0;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                // Reverse Current Word
                int currentWordEnd = i - 1;
                String reversedWord = "";
                for (int j = currentWordStart; j <= currentWordEnd; j++) {
                    reversedWord = str.charAt(j) + reversedWord;
                }
                // Add it final String(ans)
                ans += reversedWord + " ";
                currentWordStart = i + 1;
            }
        }
        int currentWordEnd = i - 1;
        String reversedWord = "";
        for (int j = currentWordStart; j <= currentWordEnd; j++) {
            reversedWord = str.charAt(j) + reversedWord;
        }
        ans += reversedWord;
        return ans;
    }

    // CN Solution

    public static String reverseWordWise(String str) {
        int end = str.length();
        int i = str.length() - 1;
        String output = "";
        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                output = output + str.substring(i + 1, end) + " ";
                end = i;
            }
            i--;
        }
        output += str.substring(i + 1, end);
        return output;
    }

    public static void main(String[] args) {
        String str = "Hi this is Vipul";
        reverseString(str);
        System.out.println(str);
        System.out.println(revWordWise(str));
    }

}
