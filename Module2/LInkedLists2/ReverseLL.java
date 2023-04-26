package Module2.LInkedLists2;

class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail;

    public DoubleNode() {
    }

    public DoubleNode(Node<Integer> head, Node<Integer> tail) {
        this.head = head;
        this.tail = tail;
    }
}

public class ReverseLL {
    public static Node<Integer> reverseR(Node<Integer> head) {
        // Time complexity O(N^2)
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> smallHead = reverseR(head.next);
        Node<Integer> tail = smallHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return smallHead;
    }

    // Better time complexity
    public static DoubleNode reverseBetter(Node<Integer> head) {
        // O(n)
        DoubleNode ans;
        if (head == null || head.next == null) {
            ans = new DoubleNode(head, head);
            // ans.head = head;
            // ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = reverseBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;

    }

    // Packer Function || Helper function;
    public static Node<Integer> reverseBetter1(Node<Integer> head) {
        DoubleNode ans = reverseBetter(head);
        return ans.head;
    }

    public static Node<Integer> reverseBest(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> smallHead = reverseBest(head.next);
        Node<Integer> revTail = head.next;
        revTail.next = head;
        head.next = null;
        return smallHead;

    }
}
