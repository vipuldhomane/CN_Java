package Module2.Recursion2;

public class ReplaceAnB {
    public static String replaceChar(String s, char a, char b) {
        if (s.length() == 0) {
            return s;
        }
        String smallOutput = replaceChar(s.substring(1), a, b);

        if (s.charAt(0) == a) {
            return b + smallOutput;
        } else {
            return s.charAt(0) + smallOutput;
        }

    }

    public static String removeX(String input) {
        if (input.length() == 0) {
            return "";
        }
        if (input.charAt(0) == 'x') {
            return removeX(input.substring(1));
        }
        return input.charAt(0) + removeX(input.substring(1));
    }

    public static void main(String[] args) {
        String str = "axvxcxdxfxgx";
        str = removeX(str);
        System.out.println(str);
    }
}
