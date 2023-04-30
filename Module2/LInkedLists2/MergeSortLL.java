package Module2.LInkedLists2;

import java.util.Scanner;

public class MergeSortLL {
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

    public static Node<Integer> mergeLL(Node<Integer> head1, Node<Integer> head2) {
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

    public static Node<Integer> mergeSortLL(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> midNode = Midpoint(head);
        Node<Integer> nextOfMiddle = midNode.next;
        midNode.next = null;

        // recursioncall
        Node<Integer> left = mergeSortLL(head);
        Node<Integer> right = mergeSortLL(nextOfMiddle);
        Node<Integer> sortedList = mergeLL(left, right);
        return sortedList;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputN();
        head = mergeSortLL(head);
        printR(head);
    }
}
