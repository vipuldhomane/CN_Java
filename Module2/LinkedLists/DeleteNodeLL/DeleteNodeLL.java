package Module2.LinkedLists.DeleteNodeLL;

import java.util.*;

public class DeleteNodeLL {
    /*
     * 
     * Time Complexity : O(min(pos, n))
     * Space Complexity : O(1)
     * Where 'pos' is the position of the node deleted
     * and 'n' being the size of the Singly Linked List
     * 
     */

    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {

        if (head == null) {
            return head;
        }

        if (pos == 0) {
            return head.next;
        }

        int count = 0;
        Node<Integer> currHead = head;
        while (currHead != null && count < (pos - 1)) {
            currHead = currHead.next;
            count++;
        }

        if (currHead == null || currHead.next == null) {
            return head;
        }

        currHead.next = currHead.next.next;

        return head;
    }

    // Input
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
        head = deleteNode(head, 1);
        PrintLL(head);
    }

}