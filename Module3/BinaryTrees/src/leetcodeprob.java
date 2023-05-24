class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderLinkedList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        // Step 3: Merge the first half and reversed second half of the linked list
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;
            firstHalf = firstNext;
            secondHalf = secondNext;
        }

        return head;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderLinkedList reorder = new ReorderLinkedList();
        ListNode result = reorder.reorderList(head);

        // Print the reordered list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
