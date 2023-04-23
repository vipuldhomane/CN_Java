package Module2.LinkedLists.LinkedList.src;

import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        Node<Integer> n4 = new Node<Integer>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public static void increment(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            temp.data++;
            temp = temp.next;
        }
    }

    public static void PrintLL(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static int LengthofLL(Node<Integer> head) {
        int len = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void printIthNode(Node<Integer> head, int i) {
        // Your code goes here
        Node<Integer> curr = head;
        int count = 0;
        while (curr != null && count < i) {
            count++;
            curr = curr.next;
        }
        if (curr != null) {
            System.out.println(curr.data);
        }
    }

    public static Node<Integer> takeInputN2() {
        // Time complexity is O(n^2)
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<Integer>(data);
            if (head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }
            data = sc.nextInt();
            sc.close();
        }
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

    public static Node<Integer> insert(Node<Integer> head, int element, int pos) {
        Node<Integer> nodeToBeInserted = new Node<Integer>(element);
        // Separately handle the zeroth position case

        if (pos == 0) {
            // point to head
            nodeToBeInserted.next = head;
            // update head
            head = nodeToBeInserted;
            return head;

        } else {

            int count = 0;
            Node<Integer> prev = head;
            while (count < pos - 1 && prev != null) {
                count++;
                prev = prev.next;
            }
            // Adding nodeToBeInserted at position using Make Before break principle.
            // Sequence is very important else it will cause infinite loop
            if (prev != null) {
                nodeToBeInserted.next = prev.next;
                prev.next = nodeToBeInserted;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        // Node<Integer> n1 = new Node<Integer>(10);
        // System.out.println(n1);
        // System.out.println(n1.data);
        // // System.out.println(n1.next.next.data);
        Node<Integer> head = takeInputN(); // createLinkedList();
        // System.out.println(head.next.next.next.data);

        head = insert(head, 40, 0);
        PrintLL(head);

    }
}
