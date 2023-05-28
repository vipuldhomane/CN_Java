import java.util.ArrayList;

public class Subsequences {
    public static ArrayList<String> returnSubs(String str) {
        if (str.length() == 0) {
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        ArrayList<String> rans = returnSubs(str.substring(1));
        ArrayList<String> myans = new ArrayList<>();

        // Add everything from rans to myans;
        for (int i = 0; i < rans.size(); i++) {
            myans.add(rans.get(i));
        }

        // Find out First char at string
        char ch = str.charAt(0);
        // now append ch to rans and add to myans
        for (int i = 0; i < rans.size(); i++) {
            myans.add(ch + rans.get(i));
        }
        return myans;
    }

    // All the way up approach
    public static void printSub(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSub(ros, asf);
        printSub(ros, asf + ch);
    }

    public static void main(String[] args) {
        String str = "abc";
        // ArrayList<String> subs = returnSubs(str);
        // System.out.println(subs);
        printSub(str, "");
    }

}
