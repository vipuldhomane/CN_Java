package Module2.LinkedLists;

import java.util.*;

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

    public static int findNode(Node<Integer> head, int n) {
        // Variable to maintain the position in the list.
        int pos = 0;

        while (head != null) {
            // If element found, return the position of the element.
            if (head.data.equals(n)) {
                return pos;
            }

            head = head.next;
            pos++;
        }

        return -1;
    }

    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
        if (n == 0 || head == null) {
            return head;
        }

        Node<Integer> fast = head;
        Node<Integer> slow = head;
        Node<Integer> initialhead = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node<Integer> temp = slow.next;
        slow.next = null;
        fast.next = initialhead;
        head = temp;

        return head;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node<Integer> currHead = head;

        while (currHead.next != null) {
            if (currHead.data.equals(currHead.next.data)) {
                currHead.next = currHead.next.next;
            } else {
                currHead = currHead.next;
            }
        }

        return head;
    }

    public static void printReverse(Node<Integer> root) {
        if (root == null) {
            return;
        }

        printReverse(root.next);
        System.out.print(root.data + " ");

    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }

    // You have been given a head to a singly linked list of integers. Write a
    // function check to whether the list given is a 'Palindrome' or not.\
    // CN Solution
    public static boolean isPalindrome(Node<Integer> head) {

        if (head == null || head.next == null) {
            return true;
        }

        // find list center
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node<Integer> secondHead = slow.next;
        slow.next = null;
        secondHead = reverseLinkedList(secondHead);

        // compare two sublists now
        Node<Integer> firstSubList = secondHead;
        Node<Integer> secondSubList = head;
        while (firstSubList != null) {
            if (firstSubList.data != secondSubList.data) {
                return false;
            }

            firstSubList = firstSubList.next;
            secondSubList = secondSubList.next;

        }

        // Rejoin the two sublists to restore the input list to its original form
        firstSubList = head;
        secondSubList = reverseLinkedList(secondHead);

        while (firstSubList.next != null) {
            firstSubList = firstSubList.next;
        }

        firstSubList.next = secondSubList;

        return true;
    }

    public static boolean isPalindrome2(Node<Integer> head) {
        Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (node != null) {
            arr.add(node.data);
            node = node.next;
        }
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            if (arr.get(start) != arr.get(end)) {
                return false;
            } else {
                start = start + 1;
                end = end - 1;
            }
        }
        return true;
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
