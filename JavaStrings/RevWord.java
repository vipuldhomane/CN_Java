package JavaStrings;

public class RevWord {
    public static String reverseEachWord(String input) {
        String ans = "";
        int currentWordStart = 0;
        int i = 0;
        for (; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                // Reverse Current Word
                int currentWordEnd = i - 1;
                String reversedWord = "";
                for (int j = currentWordStart; j <= currentWordEnd; j++) {
                    reversedWord = input.charAt(j) + reversedWord;
                }
                // Add it final String(ans)
                ans += reversedWord + " ";
                currentWordStart = i + 1;
            }
        }
        int currentWordEnd = i - 1;
        String reversedWord = "";
        for (int j = currentWordStart; j <= currentWordEnd; j++) {
            reversedWord = input.charAt(j) + reversedWord;
        }
        ans += reversedWord;
        return ans;
    }

    // Diff Approach
    // Start
    public static String rev(String s) {
        // l = 0;
        int n = s.length();
        String st = "";
        for (int i = 0; i < n; i++) {
            st = s.charAt(i) + st;
        }
        return st;
    }

    public static String reverseEachWord2(String str) {
        // Your code goes here
        String a[] = str.split(" ");
        String s = "";
        for (int i = 0; i < a.length; i++) {
            String an = rev(a[i]);
            s += an + " ";
        }
        return s;
    }
    // End

    public static void main(String[] args) {
        String input = "abc def ghi";
        System.out.println(reverseEachWord(input));
    }
}
