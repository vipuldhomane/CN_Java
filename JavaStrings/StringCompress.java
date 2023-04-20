package JavaStrings;

/**
 * StringCompress
 */
public class StringCompress {

    public static String getCompressedString(String str) {
        // Write your code here.
        char ch = str.charAt(0);
        String output = "" + ch;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count += 1;
            } else {
                ch = str.charAt(i);
                count = 1;
                if (count > 1) {
                    output += ch + count;
                } else {
                    output += ch;
                }
            }

        }
        return output;
    }

    public static String getCompressedStringmain(String str) {
        // Write your code here.
        // String s = "";
        char ch = str.charAt(0);
        String s = "";
        int c = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != ch && c != 1) {
                s += ch + Integer.toString(c);
                ch = str.charAt(i);
                c = 1;
            } else if (str.charAt(i) != ch && c == 1) {
                s += ch;
                ch = str.charAt(i);
                c = 1;
            } else {
                c++;
            }
        }
        if (c == 1) {
            return s + ch;
        } else {
            return s + ch + Integer.toString(c);
        }
    }

    public static void main(String[] args) {
        String str = "aabbcccabc";
        System.out.println(getCompressedString(str));
    }
}