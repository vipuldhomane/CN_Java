package Module2.Test6;

import Module2.LinkedLists.Node;

public class Mult2LL {

    private static int length(Node<Integer> head) {
        int len = 0;
        while (head != null) {
            len += 1;
            head = head.next;
        }
        return len;
    }

    private static Node<Integer> reverseIteratively(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> currNext = curr.next;

        while (curr != null && currNext != null) {
            curr.next = prev;
            prev = curr;
            curr = currNext;
            currNext = currNext.next;
        }

        if (curr != null) {
            curr.next = prev;
            prev = curr;
        }

        return prev;
    }

    private static Node<Integer> makeLLOfSize(int n) {
        int nc = 0;
        Node<Integer> head = null;
        Node<Integer> tail = null;

        while (nc < n) {
            Node<Integer> newNode = new Node<>(0);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            nc += 1;
        }

        return head;
    }

    private static Node<Integer> addFirst(Node<Integer> head) {
        Node<Integer> newNode = new Node<>(0);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void multiply(Node<Integer> head1, Node<Integer> head2) {
        head1 = reverseIteratively(head1);
        head2 = reverseIteratively(head2);

        int len1 = length(head1);
        int len2 = length(head2);

        Node<Integer> first = head1;
        Node<Integer> second = head2;

        int carry = 0;
        Node<Integer> res1 = makeLLOfSize(len1 + len2 + 1);

        while (second != null) {
            Node<Integer> res2 = makeLLOfSize(len1 + len2 + 1);
            first = head1;
            Node<Integer> temp2 = res2;
            Node<Integer> temp1 = res1;
            carry = 0;

            while (first != null) {
                int ans = temp1.data + carry + second.data * first.data;
                temp2.data = ans % 10;
                carry = ans / 10;
                temp2 = temp2.next;
                temp1 = temp1.next;
                first = first.next;
            }

            if (carry != 0) {
                int ans = temp1.data + carry;
                temp2.data = ans;
            }

            res1 = res2;
            head1 = addFirst(head1);

            second = second.next;
        }

        res1 = reverseIteratively(res1);

        printL(res1);
    }

    private static void printL(Node<Integer> head) {
        if (head == null)
            return;

        // keep traversing until first non-zero node is found
        while (head.data == 0) {
            head = head.next;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }
}
