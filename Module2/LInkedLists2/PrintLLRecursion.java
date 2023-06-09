package Module2.LInkedLists2;

import java.util.Scanner;

public class PrintLLRecursion {
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

    public static void main(String[] args) {
        Node<Integer> head = takeInputN();
        // printR(head);
        printReverseR(head);
    }
}
