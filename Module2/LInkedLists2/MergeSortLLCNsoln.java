package Module2.LInkedLists2;

public class MergeSortLLCNsoln {
    /*
     * Time Complexity : O(n * log n)
     * Space Complexity : O(log n)
     * Where 'n' is size of the Singly Linked List
     */

    private static Node<Integer> findMid(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node<Integer> newHead = null, newTail = null;

        if (head1.data < head2.data) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }

        }

        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }

        return newHead;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> mid = findMid(head);

        Node<Integer> half1 = head;
        Node<Integer> half2 = mid.next;
        mid.next = null;

        half1 = mergeSort(half1);
        half2 = mergeSort(half2);

        Node<Integer> finalHead = merge(half1, half2);

        return finalHead;

    }

}
