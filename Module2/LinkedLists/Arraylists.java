package Module2.LinkedLists;

import java.util.ArrayList;

public class Arraylists {
    public static void main(String[] args) {
        ArrayList<Integer> n = new ArrayList<>();
        n.add(34);
        n.add(30);
        n.add(54);
        n.add(4);
        n.add(14);
        System.out.println(n.size());
        // System.out.println(n.indexOf(34));
        n.set(1, 0);
        // System.out.println(n.get(1));

        // Printing the Array list
        for (int i = 0; i < n.size(); i++) {
            System.out.print(n.get(i) + " ");
        }
        // Another way of Printing Array using
        // Enhanced For loops
        // Dont use when we need to change elements
        for (int i : n) {
            System.out.print(i + " ");

        }
    }
}
