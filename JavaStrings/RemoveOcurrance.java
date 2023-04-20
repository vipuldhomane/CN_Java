package JavaStrings;

public class RemoveOcurrance {
    public static String removeOccureance(String str, char ch) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                ans += str.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aaabaahabaahahbahabagagahahgayauauaah";
        str = removeOccureance(str, 'a');
        System.out.println(str);
    }
}
