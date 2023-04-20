package Module2.Assignments;

public class checkAB {
    public static boolean checkAB(String s) {
        // Write your code here
        if (s.length() == 0) {
            return true;
        }
        if (s.charAt(0) == 'a') {
            if (s.substring(1).length() > 1 && s.substring(1, 3).equals("bb")) {
                return checkAB(s.substring(3));
            } else {
                return checkAB(s.substring(1));
            }
        } else {
            return false;
        }
    }

    public static boolean checkAB1(String s) {
        // Write your code here
        if (s.length() <= 0) {
            return true;
        }
        if (s.charAt(0) == 'a') {
            if (s.substring(1).length() > 1 && s.substring(1, 3).contains("bb")) {
                return checkAB(s.substring(3));
            } else {
                return checkAB(s.substring(1));
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "aabbabbbb";
        System.out.println(checkAB1(str));
    }
}
