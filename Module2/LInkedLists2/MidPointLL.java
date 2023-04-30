package Module2.LInkedLists2;

public class MidPointLL {
    public static Node<Integer> Midpoint(Node<Integer> head) {

        if (head == null) {
            return head;
        }
        Node<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
