package Module2.Assignments;

public class CheckPalindrome {
    public static boolean palindrome(String s, int si, int ei) {
        if (si >= ei) {
            return true;
        }
        if (s.charAt(si) != s.charAt(ei)) {
            return false;
        }
        return palindrome(s, si + 1, ei - 1);
    }

    public static boolean isStringPalindrome(String input) {
        return palindrome(input, 0, input.length() - 1);
    }

    public static boolean isStringPalindromeCN(String s) {
        // Write your code here
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isStringPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String str = "abcccfba";
        System.out.println(isStringPalindrome(str));
    }

}
