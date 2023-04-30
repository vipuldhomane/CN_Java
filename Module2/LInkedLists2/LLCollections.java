package Module2.LInkedLists2;

import java.util.LinkedList;

public class LLCollections {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(25);
        list.size();
        list.addFirst(63);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
