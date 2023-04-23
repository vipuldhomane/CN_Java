package Module2.LinkedLists.InsertNode;

import java.util.Scanner;

public class InsertNodeLL {
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

    public static void PrintLL(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputN();
        head = insert(head, 1, 2);
        PrintLL(head);
    }
}
