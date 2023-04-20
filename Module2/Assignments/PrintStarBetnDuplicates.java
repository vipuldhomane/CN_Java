package Module2.Assignments;

public class PrintStarBetnDuplicates {
    public static String printStar(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char first = s.charAt(0);
        char second = s.charAt(1);

        // small output
        String smallOutput = printStar(s.substring(1));
        if (first == second) {
            return first + "*" + smallOutput;

        } else {
            return first + smallOutput;
        }
    }

    // Similar to Remove Duplicates
    public static String removeDuplicate(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char first = s.charAt(0);
        char second = s.charAt(1);

        if (first == second) {
            return removeDuplicate(s.substring(1));

        } else {
            return first + removeDuplicate(s.substring(1));
        }
    }

    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(printStar(str));
    }
}
