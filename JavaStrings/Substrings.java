package JavaStrings;

public class Substrings {
    public static void substrings(String str) {
        int count = 0;
        for (int start = 0; start < str.length(); start++) {
            for (int end = start; end < str.length(); end++) {
                System.out.println(str.substring(start, end + 1));
                count++;
            }
        }
        System.out.println(count);
    }

    // Another Approach(Neglect)
    public static void substrings2(String str) {
        for (int len = 1; len < str.length(); len++) {
            for (int start = 0; start < str.length() - len; start++) {
                int end = start + len - 1;
                System.out.println(str.substring(start, end + 1));
            }
        }
    }

    public static void main(String[] args) {
        String str = new String("abcd");
        substrings(str);
    }
}
