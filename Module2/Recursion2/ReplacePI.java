package Module2.Recursion2;

public class ReplacePI {
    public static String replacePI(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
            // call recursion on n-2
            String smallOutput = replacePI(s.substring(2));
            return "3.14" + smallOutput;
        } else {
            // call recursion on n-1

            String smallOutput = replacePI(s.substring(1));
            return s.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        String str = "pibpicpi";
        System.out.println(replacePI(str));

    }
}
