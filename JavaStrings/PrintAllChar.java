package JavaStrings;

/**
 * PrintAllChar
 */
public class PrintAllChar {

    public static void printChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static int countWord(String str) {
        int count = 1;
        if (str.length() == 0) {
            return 0;
        } else {

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    count += 1;
                }
            }
            return count;
        }

    }

    public static void main(String[] args) {
        String str = "abc def";
        printChar(str);
        System.out.println(countWord(str));
    }
}