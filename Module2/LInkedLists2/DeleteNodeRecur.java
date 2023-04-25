package Module2.LInkedLists2;

import java.util.Scanner;

public class DeleteNodeRecur {
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

    public static void main(String[] args) {
        Node<Integer> head = takeInputN();
        head = deleteNodeR(head, 10);
        printR(head);
    }

}
