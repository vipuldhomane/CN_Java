package Module2.LInkedLists2.Assignment;

public class BubbleSort {
    /*
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     * Where 'n' is size of the Singly Linked List
     */

    private static int length(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;

    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {
        int n = length(head);

        for (int i = 0; i < (n - 1); i++) {

            Node<Integer> prev = null;
            Node<Integer> curr = head;

            for (int j = 0; j < (n - i - 1); j++) {
                if (curr.data <= curr.next.data) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    if (prev == null) {
                        Node<Integer> fwd = curr.next;
                        head = head.next;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    } else {
                        Node<Integer> fwd = curr.next;
                        prev.next = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                }
            }
        }
        return head;
    }
}
