package JavaStrings;

public class RemoveConsecutiveDuplicates {
    public static String removeConDuplicates(String str) {
        // here ch is initialled for each different chat
        char ch = str.charAt(0);
        String s = "" + ch;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                ch = str.charAt(i);
                s += ch;
            }
        }
        return s;

    }

    public static void main(String[] args) {
        String str = "aabbccabbbbbc";
        System.out.println(removeConDuplicates(str));
    }
}
