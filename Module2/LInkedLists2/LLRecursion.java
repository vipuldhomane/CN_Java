package Module2.LInkedLists2;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

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

public class LLRecursion {
    public static Node<Integer> takeInputN() {
        // Time complexity is O(n)
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null, tail = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<Integer>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                // Adding data at next tail position
                tail.next = currentNode;
                // moving tail one position ahead
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void printR(Node<Integer> head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printR(head.next);

    }

    public static void printReverseR(Node<Integer> head) {
        if (head == null) {
            return;
        }
        printReverseR(head.next);
        System.out.print(head.data + " ");
    }

    public static Node<Integer> insertR(Node<Integer> head, int element, int position) {

        if (head == null && position > 0) {
            return head;
        }
        if (position == 0) {
            Node<Integer> newNode = new Node<Integer>(element);
            newNode.next = head;
            return newNode;
        } else {
            head.next = insertR(head.next, element, position - 1);
            return head;
        }
    }

    public static Node<Integer> deleteNodeR(Node<Integer> head, int pos) {
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            return head.next;
        }
        head.next = deleteNodeR(head.next, pos - 1);
        return head;
    }

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

    // Midpoint IN LL
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

    public static Node<Integer> mergerLL(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> head = null, tail = null;
        if (t1.data <= t2.data) {
            head = t1;
            tail = t1;
            t1 = t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        // one list is over

        if (t1 != null) {
            tail.next = t1;
        } else {
            tail.next = t2;
        }
        return head;

    }

    public static void main(String[] args) {
        Node<Integer> head1 = takeInputN();
        Node<Integer> head2 = takeInputN();
        Node<Integer> head = mergerLL(head1, head2);
        printR(head);
        // System.out.println(Midpoint(head));

    }

}
