package Module2.LinkedLists.Assignments;

public class FindNode {
    public static int findNode(Node<Integer> head, int n) {
        // Variable to maintain the position in the list.
        int pos = 0;

        while (head != null) {
            // If element found, return the position of the element.
            if (head.data.equals(n)) {
                return pos;
            }

            head = head.next;
            pos++;
        }

        return -1;
    }
}
