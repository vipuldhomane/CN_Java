package Module2.LInkedLists2.Assignment;

public class KReverse {

    public static Node<Integer> kReverse(Node<Integer> head, int k) {

        if (k == 0 || k == 1) {
            return head;
        }

        Node<Integer> current = head;
        Node<Integer> fwd = null;
        Node<Integer> prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            fwd = current.next;
            current.next = prev;
            prev = current;
            current = fwd;
            count++;
        }

        if (fwd != null) {
            head.next = kReverse(fwd, k);
        }

        return prev;
    }

}
