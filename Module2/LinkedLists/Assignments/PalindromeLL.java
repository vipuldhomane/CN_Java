package Module2.LinkedLists.Assignments;

import java.util.ArrayList;

public class PalindromeLL {
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
}
